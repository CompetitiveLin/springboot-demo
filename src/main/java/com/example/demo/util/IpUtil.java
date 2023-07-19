package com.example.demo.util;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Ip 工具类，ip转化成地区等功能
 */
@Slf4j
public class IpUtil {

    private static String tmpPath = null;

    private static byte[] vectorIndexBuff;

    private static byte[] contentBuff;

    static {
        try {
            ClassPathResource classPathResource = new ClassPathResource("ip2region/ip2region.xdb");
            @Cleanup InputStream inputStream = classPathResource.getInputStream();
            contentBuff = FileCopyUtils.copyToByteArray(inputStream);
//            Path path = Files.createTempFile("ip2region", ".xdb");
//            Files.write(path, IOUtils.toByteArray(inputStream));    // 因为打包后无法根据路径读取压缩包里的内容，因此需要在本地路径重新写一份
//            tmpPath = path.toString();
//            log.info("Temp file: {}", tmpPath);
//            vectorIndexBuff = Searcher.loadVectorIndexFromFile(tmpPath);  // 缓存 VectorIndex 索引
//            contentBuff = Searcher.loadContentFromFile(tmpPath);  // 缓存整个 xdb 数据
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 每个线程需要单独创建一个独立的 Searcher 对象，但是都共享全局的制度 vIndex 缓存。
     *
     * @param ip ip
     * @return
     */
    @SneakyThrows
    public static List<String> getIpAddress(String ip) {

        // 使用全局的 vIndex 创建带 VectorIndex 缓存的查询对象。
        Searcher searcher = Searcher.newWithVectorIndex(tmpPath, vectorIndexBuff);

        long sTime = System.nanoTime();

        String region = searcher.search(ip);

        long cost = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - sTime);

        log.info("{region: {}, ioCount: {}, took: {} μs}", region, searcher.getIOCount(), cost);

        return Arrays.stream(region.split("\\|")).filter(s -> !"0".equals(s)).collect(Collectors.toList());
    }

    /**
     * 并发使用，用整个 xdb 数据缓存创建的查询对象可以安全的用于并发，
     * 也就是你可以把这个 searcher 对象做成全局对象去跨线程访问
     *
     * @param ip ip
     * @return
     */
    @SneakyThrows
    public static List<String> getIpAddress2(String ip) {

        // 使用上述的 contentBuff 创建一个完全基于内存的查询对象。
        Searcher searcher = Searcher.newWithBuffer(contentBuff);

        long sTime = System.nanoTime();

        String region = searcher.search(ip);

        long cost = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - sTime);

        log.info("{region: {}, ioCount: {}, took: {} μs}", region, searcher.getIOCount(), cost);

        return Arrays.stream(region.split("\\|")).filter(s -> !"0".equals(s)).collect(Collectors.toList());
    }

    public static String getIpPosition(String ip) {
        List<String> cityInfo = IpUtil.getIpAddress2(ip);
        if (cityInfo.size() > 0) {
            // 国内的显示到具体的省
            if ("中国".equals(cityInfo.get(0))) {
                if (cityInfo.size() > 1) {
                    return cityInfo.get(1);
                }
            }
            // 国外显示到国家
            return cityInfo.get(0);
        }
        return "Unknown";
    }

    public static String getIpAddr(HttpServletRequest request) {
        if (request == null) {
            return "unknown";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    public static boolean internalIp(String ip) {
        byte[] addr = textToNumericFormatV4(ip);
        return internalIp(addr) || "127.0.0.1".equals(ip);
    }

    private static boolean internalIp(byte[] addr) {
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        // 10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        // 172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        // 192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                }
            default:
                return false;
        }
    }

    /**
     * 将IPv4地址转换成字节
     *
     * @param text IPv4地址
     * @return byte 字节
     */
    public static byte[] textToNumericFormatV4(String text) {
        if (text.length() == 0) {
            return null;
        }

        byte[] bytes = new byte[4];
        String[] elements = text.split("\\.", -1);
        try {
            long l;
            int i;
            switch (elements.length) {
                case 1:
                    l = Long.parseLong(elements[0]);
                    if ((l < 0L) || (l > 4294967295L))
                        return null;
                    bytes[0] = (byte) (int) (l >> 24 & 0xFF);
                    bytes[1] = (byte) (int) ((l & 0xFFFFFF) >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 2:
                    l = Integer.parseInt(elements[0]);
                    if ((l < 0L) || (l > 255L))
                        return null;
                    bytes[0] = (byte) (int) (l & 0xFF);
                    l = Integer.parseInt(elements[1]);
                    if ((l < 0L) || (l > 16777215L))
                        return null;
                    bytes[1] = (byte) (int) (l >> 16 & 0xFF);
                    bytes[2] = (byte) (int) ((l & 0xFFFF) >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 3:
                    for (i = 0; i < 2; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L))
                            return null;
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    l = Integer.parseInt(elements[2]);
                    if ((l < 0L) || (l > 65535L))
                        return null;
                    bytes[2] = (byte) (int) (l >> 8 & 0xFF);
                    bytes[3] = (byte) (int) (l & 0xFF);
                    break;
                case 4:
                    for (i = 0; i < 4; ++i) {
                        l = Integer.parseInt(elements[i]);
                        if ((l < 0L) || (l > 255L))
                            return null;
                        bytes[i] = (byte) (int) (l & 0xFF);
                    }
                    break;
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return bytes;
    }

    public static String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
        return "127.0.0.1";
    }

    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
        }
        return "Unknown";
    }
}