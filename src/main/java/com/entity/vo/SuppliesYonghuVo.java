package com.entity.vo;

import com.entity.SuppliesUonghuEntity;
import lombok.Data;

/**
 * @Author 3fes
 * @Date 2022/4/26 9:55
 **/
@Data
public class SuppliesYonghuVo extends SuppliesUonghuEntity {

    private String yonghuming;
    private String name;
    private String img;
    private String subscribeCount;
}
