package com.example.demo.mbg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class Confirmation implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.id
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    @JsonIgnore
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.stu_id
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    @JsonIgnore
    private Long stuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.information_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Byte informationConfirmation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.information_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Date informationConfirmationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.course_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Byte courseConfirmation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.course_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Date courseConfirmationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.academic_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Byte academicConfirmation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.academic_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Date academicConfirmationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.dissertation_submitted
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Byte dissertationSubmitted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.dissertation_submitted_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private Date dissertationSubmittedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.dissertation_title
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private String dissertationTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.dissertation_keywords
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private String dissertationKeywords;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column confirmation.dissertation_abstract
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private String dissertationAbstract;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.id
     *
     * @return the value of confirmation.id
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.id
     *
     * @param id the value for confirmation.id
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.stu_id
     *
     * @return the value of confirmation.stu_id
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Long getStuId() {
        return stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.stu_id
     *
     * @param stuId the value for confirmation.stu_id
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.information_confirmation
     *
     * @return the value of confirmation.information_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Byte getInformationConfirmation() {
        return informationConfirmation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.information_confirmation
     *
     * @param informationConfirmation the value for confirmation.information_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setInformationConfirmation(Byte informationConfirmation) {
        this.informationConfirmation = informationConfirmation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.information_confirmation_time
     *
     * @return the value of confirmation.information_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Date getInformationConfirmationTime() {
        return informationConfirmationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.information_confirmation_time
     *
     * @param informationConfirmationTime the value for confirmation.information_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setInformationConfirmationTime(Date informationConfirmationTime) {
        this.informationConfirmationTime = informationConfirmationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.course_confirmation
     *
     * @return the value of confirmation.course_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Byte getCourseConfirmation() {
        return courseConfirmation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.course_confirmation
     *
     * @param courseConfirmation the value for confirmation.course_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setCourseConfirmation(Byte courseConfirmation) {
        this.courseConfirmation = courseConfirmation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.course_confirmation_time
     *
     * @return the value of confirmation.course_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Date getCourseConfirmationTime() {
        return courseConfirmationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.course_confirmation_time
     *
     * @param courseConfirmationTime the value for confirmation.course_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setCourseConfirmationTime(Date courseConfirmationTime) {
        this.courseConfirmationTime = courseConfirmationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.academic_confirmation
     *
     * @return the value of confirmation.academic_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Byte getAcademicConfirmation() {
        return academicConfirmation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.academic_confirmation
     *
     * @param academicConfirmation the value for confirmation.academic_confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setAcademicConfirmation(Byte academicConfirmation) {
        this.academicConfirmation = academicConfirmation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.academic_confirmation_time
     *
     * @return the value of confirmation.academic_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Date getAcademicConfirmationTime() {
        return academicConfirmationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.academic_confirmation_time
     *
     * @param academicConfirmationTime the value for confirmation.academic_confirmation_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setAcademicConfirmationTime(Date academicConfirmationTime) {
        this.academicConfirmationTime = academicConfirmationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.dissertation_submitted
     *
     * @return the value of confirmation.dissertation_submitted
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Byte getDissertationSubmitted() {
        return dissertationSubmitted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.dissertation_submitted
     *
     * @param dissertationSubmitted the value for confirmation.dissertation_submitted
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setDissertationSubmitted(Byte dissertationSubmitted) {
        this.dissertationSubmitted = dissertationSubmitted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.dissertation_submitted_time
     *
     * @return the value of confirmation.dissertation_submitted_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public Date getDissertationSubmittedTime() {
        return dissertationSubmittedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.dissertation_submitted_time
     *
     * @param dissertationSubmittedTime the value for confirmation.dissertation_submitted_time
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setDissertationSubmittedTime(Date dissertationSubmittedTime) {
        this.dissertationSubmittedTime = dissertationSubmittedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.dissertation_title
     *
     * @return the value of confirmation.dissertation_title
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public String getDissertationTitle() {
        return dissertationTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.dissertation_title
     *
     * @param dissertationTitle the value for confirmation.dissertation_title
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setDissertationTitle(String dissertationTitle) {
        this.dissertationTitle = dissertationTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.dissertation_keywords
     *
     * @return the value of confirmation.dissertation_keywords
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public String getDissertationKeywords() {
        return dissertationKeywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.dissertation_keywords
     *
     * @param dissertationKeywords the value for confirmation.dissertation_keywords
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setDissertationKeywords(String dissertationKeywords) {
        this.dissertationKeywords = dissertationKeywords;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column confirmation.dissertation_abstract
     *
     * @return the value of confirmation.dissertation_abstract
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public String getDissertationAbstract() {
        return dissertationAbstract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column confirmation.dissertation_abstract
     *
     * @param dissertationAbstract the value for confirmation.dissertation_abstract
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    public void setDissertationAbstract(String dissertationAbstract) {
        this.dissertationAbstract = dissertationAbstract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table confirmation
     *
     * @mbg.generated Thu May 04 11:33:49 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stuId=").append(stuId);
        sb.append(", informationConfirmation=").append(informationConfirmation);
        sb.append(", informationConfirmationTime=").append(informationConfirmationTime);
        sb.append(", courseConfirmation=").append(courseConfirmation);
        sb.append(", courseConfirmationTime=").append(courseConfirmationTime);
        sb.append(", academicConfirmation=").append(academicConfirmation);
        sb.append(", academicConfirmationTime=").append(academicConfirmationTime);
        sb.append(", dissertationSubmitted=").append(dissertationSubmitted);
        sb.append(", dissertationSubmittedTime=").append(dissertationSubmittedTime);
        sb.append(", dissertationTitle=").append(dissertationTitle);
        sb.append(", dissertationKeywords=").append(dissertationKeywords);
        sb.append(", dissertationAbstract=").append(dissertationAbstract);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}