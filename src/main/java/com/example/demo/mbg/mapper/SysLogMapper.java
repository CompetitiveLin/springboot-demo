package com.example.demo.mbg.mapper;

import com.example.demo.mbg.model.SysLog;
import com.example.demo.mbg.model.SysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    long countByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int deleteByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int insert(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int insertSelective(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    List<SysLog> selectByExample(SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    SysLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByPrimaryKeySelective(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByPrimaryKey(SysLog record);
}