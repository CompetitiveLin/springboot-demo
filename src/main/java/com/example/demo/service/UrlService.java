package com.example.demo.service;

public interface UrlService {

    String getLongUrl(String shortUrl);

    String generate(String longUrl);
}
