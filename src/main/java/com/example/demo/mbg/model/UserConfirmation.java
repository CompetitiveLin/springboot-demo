package com.example.demo.mbg.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_confirmation
 */
@TableName(value ="user_confirmation")
@Data
public class UserConfirmation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long stuId;

    /**
     * 
     */
    private Integer informationConfirmation;

    /**
     * 
     */
    private Date informationConfirmationTime;

    /**
     * 
     */
    private Integer courseConfirmation;

    /**
     * 
     */
    private Date courseConfirmationTime;

    /**
     * 
     */
    private Integer academicConfirmation;

    /**
     * 
     */
    private Date academicConfirmationTime;

    /**
     * 
     */
    private Integer dissertationSubmitted;

    /**
     * 
     */
    private Date dissertationSubmittedTime;

    /**
     * 
     */
    private String dissertationTitle;

    /**
     * 
     */
    private String dissertationKeywords;

    /**
     * 
     */
    private String dissertationAbstract;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserConfirmation other = (UserConfirmation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getInformationConfirmation() == null ? other.getInformationConfirmation() == null : this.getInformationConfirmation().equals(other.getInformationConfirmation()))
            && (this.getInformationConfirmationTime() == null ? other.getInformationConfirmationTime() == null : this.getInformationConfirmationTime().equals(other.getInformationConfirmationTime()))
            && (this.getCourseConfirmation() == null ? other.getCourseConfirmation() == null : this.getCourseConfirmation().equals(other.getCourseConfirmation()))
            && (this.getCourseConfirmationTime() == null ? other.getCourseConfirmationTime() == null : this.getCourseConfirmationTime().equals(other.getCourseConfirmationTime()))
            && (this.getAcademicConfirmation() == null ? other.getAcademicConfirmation() == null : this.getAcademicConfirmation().equals(other.getAcademicConfirmation()))
            && (this.getAcademicConfirmationTime() == null ? other.getAcademicConfirmationTime() == null : this.getAcademicConfirmationTime().equals(other.getAcademicConfirmationTime()))
            && (this.getDissertationSubmitted() == null ? other.getDissertationSubmitted() == null : this.getDissertationSubmitted().equals(other.getDissertationSubmitted()))
            && (this.getDissertationSubmittedTime() == null ? other.getDissertationSubmittedTime() == null : this.getDissertationSubmittedTime().equals(other.getDissertationSubmittedTime()))
            && (this.getDissertationTitle() == null ? other.getDissertationTitle() == null : this.getDissertationTitle().equals(other.getDissertationTitle()))
            && (this.getDissertationKeywords() == null ? other.getDissertationKeywords() == null : this.getDissertationKeywords().equals(other.getDissertationKeywords()))
            && (this.getDissertationAbstract() == null ? other.getDissertationAbstract() == null : this.getDissertationAbstract().equals(other.getDissertationAbstract()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getInformationConfirmation() == null) ? 0 : getInformationConfirmation().hashCode());
        result = prime * result + ((getInformationConfirmationTime() == null) ? 0 : getInformationConfirmationTime().hashCode());
        result = prime * result + ((getCourseConfirmation() == null) ? 0 : getCourseConfirmation().hashCode());
        result = prime * result + ((getCourseConfirmationTime() == null) ? 0 : getCourseConfirmationTime().hashCode());
        result = prime * result + ((getAcademicConfirmation() == null) ? 0 : getAcademicConfirmation().hashCode());
        result = prime * result + ((getAcademicConfirmationTime() == null) ? 0 : getAcademicConfirmationTime().hashCode());
        result = prime * result + ((getDissertationSubmitted() == null) ? 0 : getDissertationSubmitted().hashCode());
        result = prime * result + ((getDissertationSubmittedTime() == null) ? 0 : getDissertationSubmittedTime().hashCode());
        result = prime * result + ((getDissertationTitle() == null) ? 0 : getDissertationTitle().hashCode());
        result = prime * result + ((getDissertationKeywords() == null) ? 0 : getDissertationKeywords().hashCode());
        result = prime * result + ((getDissertationAbstract() == null) ? 0 : getDissertationAbstract().hashCode());
        return result;
    }

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