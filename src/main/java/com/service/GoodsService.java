package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.GoodsEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<GoodsEntity> selectListView(Wrapper<GoodsEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsEntity> wrapper);

    List<GoodsEntity> getHasGoodsListByTypeId(String typeId);
}
