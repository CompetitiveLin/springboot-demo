package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    private final UserConfirmationMapper userConfirmationMapper;

    private final CourseStudentMapper courseStudentMapper;

    private final AcademicStudentMapper academicStudentMapper;


    @Override
    public void submitDissertation(String username, String title, String keywords, String abstracts) {
        UserConfirmation confirmation = getConfirmationByUsername(username);
        if (confirmation.getDissertationSubmitted().equals(1)) Asserts.fail("Already clicked Academic");
        UpdateWrapper<UserConfirmation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserConfirmation::getStuId, confirmation.getStuId())
                .set(UserConfirmation::getDissertationSubmitted, 1)
                .set(UserConfirmation::getDissertationSubmittedTime, new DateTime())
                .set(UserConfirmation::getDissertationTitle, title)
                .set(UserConfirmation::getDissertationKeywords, keywords)
                .set(UserConfirmation::getDissertationAbstract, abstracts);
        userConfirmationMapper.update(null, updateWrapper);
    }

    @Override
    public void clickInformation(String username) {
        UserConfirmation confirmation = getConfirmationByUsername(username);
        if (confirmation.getInformationConfirmation().equals(1)) Asserts.fail("Already clicked Academic");
        UpdateWrapper<UserConfirmation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserConfirmation::getStuId, confirmation.getStuId())
                .set(UserConfirmation::getInformationConfirmation, 1).set(UserConfirmation::getInformationConfirmationTime, new DateTime());
        userConfirmationMapper.update(null, updateWrapper);
    }

    @Override
    public void clickCourse(String username) {
        UserConfirmation confirmation = getConfirmationByUsername(username);
        if (confirmation.getCourseConfirmation().equals(1)) Asserts.fail("Already clicked Academic");
        UpdateWrapper<UserConfirmation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserConfirmation::getStuId, confirmation.getStuId())
                .set(UserConfirmation::getCourseConfirmation, 1).set(UserConfirmation::getCourseConfirmationTime, new DateTime());
        userConfirmationMapper.update(null, updateWrapper);
    }

    @Override
    public void clickAcademic(String username) {
        UserConfirmation confirmation = getConfirmationByUsername(username);
        if (confirmation.getAcademicConfirmation().equals(1)) Asserts.fail("Already clicked Academic");
        UpdateWrapper<UserConfirmation> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(UserConfirmation::getStuId, confirmation.getStuId())
                .set(UserConfirmation::getAcademicConfirmation, 1).set(UserConfirmation::getAcademicConfirmationTime, new DateTime());
        userConfirmationMapper.update(null, updateWrapper);
    }

    @Override
    public UserConfirmation getConfirmationByUsername(String username) {
        UserInfo userInfo = userInfoService.getUserByUsername(username);
        QueryWrapper<UserConfirmation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserConfirmation::getStuId, userInfo.getId());
        return userConfirmationMapper.selectOne(queryWrapper);
    }

    @Override
    public List<CourseStudent> getCourseStudentByUsername(String username) {
        UserInfo userInfo = userInfoService.getUserByUsername(username);
        QueryWrapper<CourseStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(CourseStudent::getStuId, userInfo.getId());
        return courseStudentMapper.selectList(queryWrapper);
    }

    @Override
    public List<AcademicStudent> getAcademicStudentByUsername(String username) {
        UserInfo userInfo = userInfoService.getUserByUsername(username);
        QueryWrapper<AcademicStudent> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AcademicStudent::getStuId, userInfo.getId());
        return academicStudentMapper.selectList(queryWrapper);
    }
}
