package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.FloorEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/25 10:11
 **/


public interface FloorDao extends BaseMapper<FloorEntity> {
    List<FloorEntity> selectListView(@Param("ew") Wrapper<FloorEntity> wrapper);
    List<FloorEntity> selectListView(Pagination page, @Param("ew") Wrapper<FloorEntity> wrapper);

}
