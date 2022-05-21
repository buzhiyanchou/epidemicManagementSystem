package com.entity.vo;

import com.entity.GoodsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author 3fes
 * @Date 2022/4/26 16:33
 **/

@Data
public class AppotinmentGoodsVo extends GoodsEntity {

    private Integer appointmentId;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date appointmentTime;
}
