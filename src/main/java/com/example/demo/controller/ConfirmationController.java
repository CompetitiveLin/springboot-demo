package com.example.demo.controller;

import com.example.demo.annotation.ParseToken;
import com.example.demo.response.CommonResult;
import com.example.demo.service.UserConfirmationService;
import com.example.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/confirmation")
@RequiredArgsConstructor
@Validated
public class ConfirmationController {

    public final UserConfirmationService userConfirmationService;


    @GetMapping("/course")
    public CommonResult<?> getCourse(@ParseToken String username) {
        return CommonResult.success(userConfirmationService.getCourseStudentByUsername(username));
    }

    @GetMapping("/academic")
    public CommonResult<?> getAcademic(@ParseToken String username) {
        return CommonResult.success(userConfirmationService.getAcademicStudentByUsername(username));
    }

    @GetMapping("/confirmation")
    public CommonResult<?> getUserConfirmationService(@ParseToken String username) {
        return CommonResult.success(userConfirmationService.getConfirmationByUsername(username));
    }

    //    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/confirm/information")
    public CommonResult<?> clickInformation(@ParseToken String username) {
        userConfirmationService.clickInformation(username);
        return CommonResult.success();
    }

    //    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/confirm/course")
    public CommonResult<?> clickCourse(@ParseToken String username) {
        userConfirmationService.clickCourse(username);
        return CommonResult.success();
    }

    //    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/confirm/academic")
    public CommonResult<?> clickAcademic(@ParseToken String username) {
        userConfirmationService.clickAcademic(username);
        return CommonResult.success();
    }


    @PostMapping("/confirm/submit")
    public CommonResult<?> submitDissertation(@ParseToken String username,
                                              @NotNull String title,
                                              @NotNull String keywords,
                                              @NotNull String abstracts) {
        userConfirmationService.submitDissertation(username, title, keywords, abstracts);
        return CommonResult.success();
    }
}
