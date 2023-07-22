package com.example.demo.mbg.mapper;

import com.example.demo.mbg.model.UserLoginLog;
import com.example.demo.mbg.model.UserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    long countByExample(UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int deleteByExample(UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int insert(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int insertSelective(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    List<UserLoginLog> selectByExample(UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    UserLoginLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int updateByExampleSelective(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int updateByExample(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int updateByPrimaryKeySelective(UserLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login_log
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    int updateByPrimaryKey(UserLoginLog record);
}