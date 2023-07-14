package com.example.demo.controller;


import com.example.demo.annotation.ParseToken;
import com.example.demo.response.CommonResult;
import com.example.demo.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/checkout")
@RestController
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/checkout")
    public CommonResult<?> checkout(@ParseToken String username){
        checkoutService.checkout(username);
        return CommonResult.success();
    }

    @GetMapping("/is-checkout")
    public CommonResult<Boolean> isCheckout(@ParseToken String username){
        return CommonResult.success(checkoutService.isCheckout(username));
    }
}
