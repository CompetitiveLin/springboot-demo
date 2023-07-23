package com.example.demo.controller;

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

    private final UserInfoService userInfoService;

    @GetMapping("/information")
    public CommonResult<?> getInformation(String username) {
        return CommonResult.success(userInfoService.getUserByUsername(username));
    }


    @GetMapping("/course")
    public CommonResult<?> getCourse(String username) {
        return CommonResult.success(userConfirmationService.getCourseStudentByUsername(username));
    }

    @GetMapping("/academic")
    public CommonResult<?> getAcademic(String username) {
        return CommonResult.success(userConfirmationService.getAcademicStudentByUsername(username));
    }

    @GetMapping("/confirmation")
    public CommonResult<?> getUserConfirmationService(String username) {
        return CommonResult.success(userConfirmationService.getConfirmationByUsername(username));
    }

    //    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/confirm/information")
    public CommonResult<?> clickInformation(String username) {
        userConfirmationService.clickInformation(username);
        return CommonResult.success();
    }

    //    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/confirm/course")
    public CommonResult<?> clickCourse(String username) {
        userConfirmationService.clickCourse(username);
        return CommonResult.success();
    }

    //    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/confirm/academic")
    public CommonResult<?> clickAcademic(String username) {
        userConfirmationService.clickAcademic(username);
        return CommonResult.success();
    }


    @PostMapping("/confirm/submit")
    public CommonResult<?> submitDissertation(@NotNull String username,
                                              @NotNull String title,
                                              @NotNull String keywords,
                                              @NotNull String abstracts) {
        userConfirmationService.submitDissertation(username, title, keywords, abstracts);
        return CommonResult.success();
    }
}
