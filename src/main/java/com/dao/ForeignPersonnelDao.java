package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.ForeignPersonnelEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface ForeignPersonnelDao extends BaseMapper<ForeignPersonnelEntity> {
    List<ForeignPersonnelEntity> selectListView(@Param("ew") Wrapper<ForeignPersonnelEntity> wrapper);
    List<ForeignPersonnelEntity> selectListView(Pagination page, @Param("ew") Wrapper<ForeignPersonnelEntity> wrapper);


}
