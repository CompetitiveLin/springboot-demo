package com.example.demo.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class AcademicStudent implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column academic_student.id
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column academic_student.stu_id
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    private Long stuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column academic_student.academic_title
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    private String academicTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column academic_student.publish_time
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    private Date publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table academic_student
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column academic_student.id
     *
     * @return the value of academic_student.id
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column academic_student.id
     *
     * @param id the value for academic_student.id
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column academic_student.stu_id
     *
     * @return the value of academic_student.stu_id
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public Long getStuId() {
        return stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column academic_student.stu_id
     *
     * @param stuId the value for academic_student.stu_id
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column academic_student.academic_title
     *
     * @return the value of academic_student.academic_title
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public String getAcademicTitle() {
        return academicTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column academic_student.academic_title
     *
     * @param academicTitle the value for academic_student.academic_title
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column academic_student.publish_time
     *
     * @return the value of academic_student.publish_time
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column academic_student.publish_time
     *
     * @param publishTime the value for academic_student.publish_time
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table academic_student
     *
     * @mbg.generated Sat Jul 22 20:32:02 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stuId=").append(stuId);
        sb.append(", academicTitle=").append(academicTitle);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}