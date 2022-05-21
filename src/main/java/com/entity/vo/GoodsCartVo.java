package com.entity.vo;

import com.entity.GoodsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author 3fes
 * @Date 2022/4/26 17:07
 **/

@Data
public class GoodsCartVo extends GoodsEntity {

    private Integer cartId;
    private String goodsNum;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date cartCreateTime;
}
