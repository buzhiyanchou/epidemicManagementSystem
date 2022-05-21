package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.GoodsAppointmentAppEntity;
import com.entity.GoodsEntity;
import com.entity.vo.AppotinmentGoodsVo;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface GoodsAppointmentService extends IService<GoodsAppointmentAppEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<GoodsAppointmentAppEntity> selectListView(Wrapper<GoodsAppointmentAppEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsAppointmentAppEntity> wrapper);

    List<AppotinmentGoodsVo> getGoodsAppointListByYongHuId(String yonghuId);
}
