package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.LocationInfoEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface LocationInfoService extends IService<LocationInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<LocationInfoEntity> selectListView(Wrapper<LocationInfoEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<LocationInfoEntity> wrapper);

    List<LocationInfoEntity> getLocationInfoByYonghuId(String yonghuId);

}
