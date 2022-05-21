package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface GoodsDao extends BaseMapper<GoodsEntity> {
    List<GoodsEntity> selectListView(@Param("ew") Wrapper<GoodsEntity> wrapper);
    List<GoodsEntity> selectListView(Pagination page, @Param("ew") Wrapper<GoodsEntity> wrapper);

    List<GoodsEntity> getHasGoodsListByTypeId(String typeId);
}
