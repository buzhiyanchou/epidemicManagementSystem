package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 3fes
 * @Date 2022/4/25 10:09
 **/

@Data
@TableName("floor")
public class FloorEntity extends BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String areaId;
    private String floorNum;
}
