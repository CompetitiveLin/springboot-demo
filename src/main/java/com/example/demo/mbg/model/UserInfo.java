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
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态：0锁定，1有效
     */
    private Integer status;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 性别：0男，1女
     */
    private Integer sex;

    /**
     * 权限：0管理员，1教师，2家长
     */
    private Integer permission;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 入学（职）时间
     */
    private Date enrollDate;

    /**
     * 预计毕业时间（学生）
     */
    private Date graduateDate;

    /**
     * 院系
     */
    private String department;

    /**
     * 系所
     */
    private String institute;

    /**
     * 账号创建时间
     */
    private Date createdTime;

    /**
     * 账号修改时间
     */
    private Date updatedTime;

    /**
     * 账号删除标记
     */
    private Boolean isDeleted;

    /**
     * 账号删除时间
     */
    private Date deletedTime;

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
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPermission() == null ? other.getPermission() == null : this.getPermission().equals(other.getPermission()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getEnrollDate() == null ? other.getEnrollDate() == null : this.getEnrollDate().equals(other.getEnrollDate()))
            && (this.getGraduateDate() == null ? other.getGraduateDate() == null : this.getGraduateDate().equals(other.getGraduateDate()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getInstitute() == null ? other.getInstitute() == null : this.getInstitute().equals(other.getInstitute()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getDeletedTime() == null ? other.getDeletedTime() == null : this.getDeletedTime().equals(other.getDeletedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPermission() == null) ? 0 : getPermission().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getEnrollDate() == null) ? 0 : getEnrollDate().hashCode());
        result = prime * result + ((getGraduateDate() == null) ? 0 : getGraduateDate().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getInstitute() == null) ? 0 : getInstitute().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getDeletedTime() == null) ? 0 : getDeletedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", avatar=").append(avatar);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", sex=").append(sex);
        sb.append(", permission=").append(permission);
        sb.append(", birth=").append(birth);
        sb.append(", enrollDate=").append(enrollDate);
        sb.append(", graduateDate=").append(graduateDate);
        sb.append(", department=").append(department);
        sb.append(", institute=").append(institute);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", deletedTime=").append(deletedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}