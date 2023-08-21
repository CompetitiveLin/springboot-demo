package com.example.demo.controller;

import com.example.demo.dto.UrlDto;
import com.example.demo.response.CommonResult;
import com.example.demo.service.UrlService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Tag(name = "ShortURLController", description = "长链转短链")
@RestController
@RequiredArgsConstructor
@RequestMapping("/u")
public class ShortURLController {

    private final UrlService urlService;

    @PostMapping("/generate")
    public CommonResult<?> generateShortURL(@RequestBody UrlDto urlDto) {
        String shortUrl = urlService.generate(urlDto.getLongUrl());
        return CommonResult.success(shortUrl);
    }

    @GetMapping("/{shortURL}")
    public void sendRedirect(HttpServletResponse response, @PathVariable String shortURL) throws IOException {
        String url = "https://www.baidu.com";
        response.sendRedirect(url);
    }
}
