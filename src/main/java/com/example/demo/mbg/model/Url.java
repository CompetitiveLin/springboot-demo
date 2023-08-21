package com.example.demo.mbg.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "url")
@Data
public class Url implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 短链接
     */
    private String surl;


    /**
     * 长链接
     */
    private String lurl;


    /**
     * 访问量
     */
    private Integer views;


    /**
     * 创建时间
     */
    private Date createTime;


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
        Url other = (Url) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSurl() == null ? other.getSurl() == null : this.getSurl().equals(other.getSurl()))
                && (this.getLurl() == null ? other.getLurl() == null : this.getLurl().equals(other.getLurl()))
                && (this.getViews() == null ? other.getViews() == null : this.getViews().equals(other.getViews()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSurl() == null) ? 0 : getSurl().hashCode());
        result = prime * result + ((getLurl() == null) ? 0 : getLurl().hashCode());
        result = prime * result + ((getViews() == null) ? 0 : getViews().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", method=").append(surl);
        sb.append(", duration=").append(lurl);
        sb.append(", params=").append(views);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
