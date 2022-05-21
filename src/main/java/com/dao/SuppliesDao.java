package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.SuppliesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface SuppliesDao extends BaseMapper<SuppliesEntity> {
    List<SuppliesEntity> selectListView(@Param("ew") Wrapper<SuppliesEntity> wrapper);
    List<SuppliesEntity> selectListView(Pagination page, @Param("ew") Wrapper<SuppliesEntity> wrapper);


}
