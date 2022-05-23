package com.entity;


import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


@TableName("epidemicLog")
public class EpidemicLog<T> implements Serializable {

    public EpidemicLog() {

    }

    public EpidemicLog(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Integer id;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date qzTime;

    private Integer userId;

    private String remark;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date wzzTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date glTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date zyTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getQzTime() {
        return qzTime;
    }

    public void setQzTime(Date qzTime) {
        this.qzTime = qzTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getWzzTime() {
        return wzzTime;
    }

    public void setWzzTime(Date wzzTime) {
        this.wzzTime = wzzTime;
    }

    public Date getGlTime() {
        return glTime;
    }

    public void setGlTime(Date glTime) {
        this.glTime = glTime;
    }

    public Date getZyTime() {
        return zyTime;
    }

    public void setZyTime(Date zyTime) {
        this.zyTime = zyTime;
    }
}
