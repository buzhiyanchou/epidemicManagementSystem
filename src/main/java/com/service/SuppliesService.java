package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.SuppliesEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface SuppliesService extends IService<SuppliesEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<SuppliesEntity> selectListView(Wrapper<SuppliesEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<SuppliesEntity> wrapper);
}
