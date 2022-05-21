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
 * @Date 2022/4/24 23:17
 **/
@Data
@TableName("supplies_yonghu")
public class SuppliesUonghuEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String suppliesId;
    private String yonghuId;
    private String subscribeCount;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createTime;
}
