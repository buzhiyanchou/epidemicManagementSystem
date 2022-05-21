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
@TableName("yonghu_addr")
public class YongHuAddrEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String yonghuId;
    private String areaId;
    private String floorId;
    private String roomId;
}
