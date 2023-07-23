package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.exception.Asserts;
import com.example.demo.mbg.mapper.AcademicStudentMapper;
import com.example.demo.mbg.mapper.CourseStudentMapper;
import com.example.demo.mbg.mapper.UserConfirmationMapper;
import com.example.demo.mbg.model.*;
import com.example.demo.service.UserConfirmationService;
import com.example.demo.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserConfirmationServiceImpl extends ServiceImpl<UserConfirmationMapper, UserConfirmation>
        implements UserConfirmationService {

    public final UserInfoService userInfoService;

    private final UserConfirmationMapper confirmationMapper;

    private final CourseStudentMapper courseStudentMapper;

    private final AcademicStudentMapper academicStudentMapper;


    @Override
    public void submitDissertation(String username, String title, String keywords, String abstracts) {
//        Confirmation confirmation = getConfirmationByUsername(username);
//        if(confirmation.getDissertationSubmitted().equals((byte)1)) Asserts.fail("Already submitted dissertation");
//        confirmation.setDissertationSubmitted((byte)1);
//        confirmation.setDissertationSubmittedTime(new DateTime());
//        confirmation.setDissertationTitle(title);
//        confirmation.setDissertationKeywords(keywords);
//        confirmation.setDissertationAbstract(abstracts);
//        confirmationMapper.updateByPrimaryKeySelective(confirmation);
    }

    @Override
    public void clickInformation(String username) {
//        Confirmation confirmation = getConfirmationByUsername(username);
//        if(confirmation.getInformationConfirmation().equals((byte)1)) Asserts.fail("Already clicked information");
//        confirmation.setInformationConfirmation((byte)1);
//        confirmation.setInformationConfirmationTime(new DateTime());
//        confirmationMapper.updateByPrimaryKeySelective(confirmation);
    }

    @Override
    public void clickCourse(String username) {
//        Confirmation confirmation = getConfirmationByUsername(username);
//        if(confirmation.getCourseConfirmation().equals((byte)1)) Asserts.fail("Already clicked Course");
//        confirmation.setCourseConfirmation((byte)1);
//        confirmation.setCourseConfirmationTime(new DateTime());
//        confirmationMapper.updateByPrimaryKeySelective(confirmation);
    }

    @Override
    public void clickAcademic(String username) {
//        Confirmation confirmation = getConfirmationByUsername(username);
//        if(confirmation.getAcademicConfirmation().equals((byte)1)) Asserts.fail("Already clicked Academic");
//        confirmation.setAcademicConfirmation((byte)1);
//        confirmation.setAcademicConfirmationTime(new DateTime());
//        confirmationMapper.updateByPrimaryKeySelective(confirmation);
    }

    @Override
    public UserConfirmation getConfirmationByUsername(String username) {
//        UserInfo userInfo = userInfoService.getUserByUsername(username);
//        if(userInfo == null) Asserts.fail("username not found");
//        ConfirmationExample example = new ConfirmationExample();
//        example.createCriteria().andStuIdEqualTo(userInfo.getId());
//        List<Confirmation> list = confirmationMapper.selectByExample(example);
//        if(CollUtil.isNotEmpty(list)) return list.get(0);
        return null;
    }

    @Override
    public List<CourseStudent> getCourseStudentByUsername(String username) {
//        UserInfo userInfo = userInfoService.getUserByUsername(username);
//        if(userInfo == null) Asserts.fail("username not found");
//        CourseStudentExample example = new CourseStudentExample();
//        example.createCriteria().andStuIdEqualTo(userInfo.getId());
//        List<CourseStudent> list = courseStudentMapper.selectByExample(example);
//        return list;
        return null;
    }

    @Override
    public List<AcademicStudent> getAcademicStudentByUsername(String username) {
//        UserInfo userInfo = userInfoService.getUserByUsername(username);
//        if(userInfo == null) Asserts.fail("username not found");
//        AcademicStudentExample example = new AcademicStudentExample();
//        example.createCriteria().andStuIdEqualTo(userInfo.getId());
//        List<AcademicStudent> list = academicStudentMapper.selectByExample(example);
//        return list;
        return null;
    }
}
