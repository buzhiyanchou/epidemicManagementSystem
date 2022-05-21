package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 3fes
 * @Date 2022/4/25 20:11
 **/

@Data
@TableName("location_info")
public class LocationInfoEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String yonghuId;
    private String temperature;
    private Integer symptom;
    private Integer isHospitalize;
    private Integer insulateStatus;
    private String newContact;
    private String locationInfo;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createTime;
}
