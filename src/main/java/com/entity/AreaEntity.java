package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:17
 **/
@Data
@TableName("area")
public class AreaEntity extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String areaName;
    private Integer areaType;

}
