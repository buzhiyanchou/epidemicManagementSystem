package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:17
 **/
@Data
@TableName("supplies")
public class SuppliesEntity extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String img;
    private String description;
    private Integer inventory;

}
