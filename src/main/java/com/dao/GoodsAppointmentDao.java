package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.GoodsAppointmentAppEntity;
import com.entity.GoodsEntity;
import com.entity.vo.AppotinmentGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface GoodsAppointmentDao extends BaseMapper<GoodsAppointmentAppEntity> {
    List<GoodsAppointmentAppEntity> selectListView(@Param("ew") Wrapper<GoodsAppointmentAppEntity> wrapper);
    List<GoodsAppointmentAppEntity> selectListView(Pagination page, @Param("ew") Wrapper<GoodsAppointmentAppEntity> wrapper);

    List<AppotinmentGoodsVo> getGoodsAppointListByYongHuId(String yonghuId);

}
