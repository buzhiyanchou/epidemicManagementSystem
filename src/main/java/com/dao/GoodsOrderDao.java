package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.GoodsOrderEntity;
import com.entity.vo.GoodsOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface GoodsOrderDao extends BaseMapper<GoodsOrderEntity> {
    List<GoodsOrderEntity> selectListView(@Param("ew") Wrapper<GoodsOrderEntity> wrapper);
    List<GoodsOrderEntity> selectListView(Pagination page, @Param("ew") Wrapper<GoodsOrderEntity> wrapper);

    List<GoodsOrderVo> getGoodsOrderList(String yonghuId);
}
