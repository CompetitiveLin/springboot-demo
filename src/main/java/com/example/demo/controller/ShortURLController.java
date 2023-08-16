package com.example.demo.controller;

import com.example.demo.response.CommonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Tag(name = "ShortURLController", description = "长链转短链")
@RestController
@RequestMapping("/u")
public class ShortURLController {

    @PostMapping("/generate")
    public CommonResult<?> generateShortURL() {
        return CommonResult.failed();
    }

    @GetMapping("/{shortURL}")
    public void sendRedirect(HttpServletResponse response, @PathVariable String shortURL) throws IOException {
        String url = "https://www.baidu.com";
        response.sendRedirect(url);
    }
}
