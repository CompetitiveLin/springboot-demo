package com.example.demo.controller;

import com.example.demo.mbg.model.UserInfo;
import com.example.demo.response.CommonResult;
import com.example.demo.service.ConfirmationService;
import com.example.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Validated
public class ConfirmationController {

    public final ConfirmationService confirmationService;

    private final UserInfoService userInfoService;

    @GetMapping("/information")
    public CommonResult getInformation(String username){
        return CommonResult.success(userInfoService.getUserByUsername(username));
    }


    @GetMapping("/course")
    public CommonResult getCourse(String username){
        return CommonResult.success(confirmationService.getCourseStudentByUsername(username));
    }

    @GetMapping("/academic")
    public CommonResult getAcademic(String username){
        return CommonResult.success(confirmationService.getAcademicStudentByUsername(username));
    }

    @GetMapping("/confirmation")
    public CommonResult getConfirmationService(String username) {
        return CommonResult.success(confirmationService.getConfirmationByUsername(username));
    }

//    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/clickInformation")
    public CommonResult clickInformation(String username) {
        confirmationService.clickInformation(username);
        return CommonResult.success();
    }

//    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/clickCourse")
    public CommonResult clickCourse(String username){
        confirmationService.clickCourse(username);
        return CommonResult.success();
    }

//    @PreAuthorize("hasAuthority('student')")
    @PostMapping("/clickAcademic")
    public CommonResult clickAcademic(String username){
        confirmationService.clickAcademic(username);
        return CommonResult.success();
    }


    @PostMapping("/submit")
    public CommonResult submitDissertation(@NotNull String username,
                                           @NotNull String title,
                                           @NotNull String keywords,
                                           @NotNull String abstracts){
        confirmationService.submitDissertation(username, title, keywords, abstracts);
        return CommonResult.success();
    }
}
