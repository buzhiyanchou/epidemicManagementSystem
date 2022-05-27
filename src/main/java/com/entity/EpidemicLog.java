package com.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


@TableName("epidemiclog")
@Data
public class EpidemicLog implements Serializable {


    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String id;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date qzTime;

    @TableField("user_id")
    private Long userId;

    private String remark;

    @TableField(exist = false)
    private String name;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @TableField("wzz_time")
    private Date wzzTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @TableField("gl_time")
    private Date glTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    @TableField("zy_time")
    private Date zyTime;



}
