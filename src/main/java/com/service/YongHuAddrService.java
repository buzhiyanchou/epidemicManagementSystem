package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.YongHuAddrEntity;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface YongHuAddrService extends IService<YongHuAddrEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<YongHuAddrEntity> selectListView(Wrapper<YongHuAddrEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<YongHuAddrEntity> wrapper);
    String getYonAddrByYongId(String yonghuId);

    void removeByYongHuIds(List<String> yonghuIds);
}
