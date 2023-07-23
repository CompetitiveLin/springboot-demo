package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mbg.model.AcademicStudent;
import com.example.demo.mbg.model.CourseStudent;
import com.example.demo.mbg.model.UserConfirmation;

import java.util.List;


public interface UserConfirmationService extends IService<UserConfirmation> {

    void submitDissertation(String username, String title, String keywords, String abstracts);

    void clickInformation(String username);

    void clickCourse(String username);

    void clickAcademic(String username);

    UserConfirmation getConfirmationByUsername(String username);

    List<CourseStudent> getCourseStudentByUsername(String username);

    List<AcademicStudent> getAcademicStudentByUsername(String username);
}
