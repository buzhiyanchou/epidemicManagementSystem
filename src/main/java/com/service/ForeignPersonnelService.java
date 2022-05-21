package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.ForeignPersonnelEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface ForeignPersonnelService extends IService<ForeignPersonnelEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<ForeignPersonnelEntity> selectListView(Wrapper<ForeignPersonnelEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<ForeignPersonnelEntity> wrapper);
}
