package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.GoodsOrderEntity;
import com.entity.vo.GoodsOrderVo;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface GoodsOrderService extends IService<GoodsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<GoodsOrderEntity> selectListView(Wrapper<GoodsOrderEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsOrderEntity> wrapper);

    List<GoodsOrderVo> getGoodsOrderList(String yonghuId);
}
