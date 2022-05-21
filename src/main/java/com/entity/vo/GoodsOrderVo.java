package com.entity.vo;

import com.entity.GoodsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author 3fes
 * @Date 2022/4/26 20:43
 **/

@Data
public class GoodsOrderVo {


    private String orderId;
    private String orderNum;
    private String yonghuId;
    private String goodsId;
    private String goodsNum;
    private String totalPrice;
    private String goodsStatus;
    private String goodsAddr;

    private String orderTime;

    private Long id;
    private String goodsTypeId;
    private String goodsName;
    private String img;
    private String describe;
    private String price;
    private String inventory;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date createTime;

}
