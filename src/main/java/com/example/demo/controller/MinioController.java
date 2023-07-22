package com.example.demo.controller;

import com.example.demo.exception.Asserts;
import com.example.demo.response.CommonResult;
import io.minio.*;
import io.minio.errors.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Tag(name = "MinioController", description = "MinIO对象存储管理")
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;

    @SneakyThrows
    @Operation(description = "文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public CommonResult<?> upload(@RequestParam("file") MultipartFile file, String username) {

        //创建一个MinIO的Java客户端
        MinioClient minioClient = MinioClient.builder().endpoint(ENDPOINT).credentials(ACCESS_KEY, SECRET_KEY).build();
        boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
        if (!isExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
        }
        String filename = file.getOriginalFilename();
        if (filename != null && !filename.endsWith("pdf")) Asserts.fail("Please upload pdf file!");
        // 设置存储对象名称
        String objectName = username + ".pdf";
        minioClient.putObject(PutObjectArgs.builder()       // 使用putObject上传一个文件到存储桶中
                .bucket(BUCKET_NAME)
                .object(objectName)
                .stream(file.getInputStream(), file.getInputStream().available(), -1)
                .contentType(file.getContentType())
                .build());
//            minioClient.uploadObject(UploadObjectArgs.builder()     // uploadObject适合上传比较大的文件
//                            .bucket(BUCKET_NAME)
//                            .object(objectName)
//                            .filename("C:\\Users\\CompetitiveLin\\Postman\\files\\20220607_051616000_iOS.mp4")  // Absolute path in server
//                            .contentType(file.getContentType())
//                            .build());
        log.info("文件上传成功!");
        Map<String, String> map = new HashMap<>();
        map.put("filename", filename);
        map.put("url", ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);
        return CommonResult.success(map);

    }

    @Operation(description = "文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult<?> delete(@RequestParam("username") String objectName) {
        try {
            MinioClient minioClient = MinioClient.builder().endpoint(ENDPOINT).credentials(ACCESS_KEY, SECRET_KEY).build();
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(BUCKET_NAME).object(objectName + ".pdf").build());
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }


    @Operation(description = "文件下载")
    @GetMapping("/download")
    public CommonResult<?> get() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String username = "51255902052";
        MinioClient minioClient = MinioClient.builder().endpoint(ENDPOINT).credentials(ACCESS_KEY, SECRET_KEY).build();
        minioClient.downloadObject(
                DownloadObjectArgs.builder()
                        .bucket(BUCKET_NAME)
                        .object(username + ".pdf")
                        .filename(username + ".pdf")
                        .build());
        return CommonResult.success();


    }
}
