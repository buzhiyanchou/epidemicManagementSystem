package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.RoomEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface RoomDao extends BaseMapper<RoomEntity> {
    List<RoomEntity> selectListView(@Param("ew") Wrapper<RoomEntity> wrapper);
    List<RoomEntity> selectListView(Pagination page, @Param("ew") Wrapper<RoomEntity> wrapper);
}
