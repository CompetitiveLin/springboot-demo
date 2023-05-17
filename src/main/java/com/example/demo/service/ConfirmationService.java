package com.example.demo.service;

import com.example.demo.mbg.model.AcademicStudent;
import com.example.demo.mbg.model.Confirmation;
import com.example.demo.mbg.model.CourseStudent;

import java.util.HashMap;
import java.util.List;


public interface ConfirmationService {

    void submitDissertation(String username, String title, String keywords, String abstracts);

    void clickInformation(String username);

    void clickCourse(String username);

    void clickAcademic(String username);

    Confirmation getConfirmationByUsername(String username);

    List<CourseStudent> getCourseStudentByUsername(String username);

    List<AcademicStudent> getAcademicStudentByUsername(String username);
}
