package com.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class EpidemicLogVo{

    private String id;

    private Date qzTime;

    private Long userId;

    private String remark;

    private String name;

    private Date wzzTime;

    private Date glTime;

    private Date zyTime;

    private String yonghuming;
    private Integer status;

}
