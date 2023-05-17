package com.example.demo.mbg.mapper;

import com.example.demo.mbg.model.Confirmation;
import com.example.demo.mbg.model.ConfirmationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfirmationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    long countByExample(ConfirmationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int deleteByExample(ConfirmationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int insert(Confirmation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int insertSelective(Confirmation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    List<Confirmation> selectByExample(ConfirmationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    Confirmation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByExampleSelective(@Param("record") Confirmation record, @Param("example") ConfirmationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByExample(@Param("record") Confirmation record, @Param("example") ConfirmationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByPrimaryKeySelective(Confirmation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    int updateByPrimaryKey(Confirmation record);
}