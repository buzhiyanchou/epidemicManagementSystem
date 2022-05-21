package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.SuppliesUonghuEntity;
import com.entity.vo.SuppliesYonghuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface SuppliesYonghuDao extends BaseMapper<SuppliesUonghuEntity> {
    List<SuppliesUonghuEntity> selectListView(@Param("ew") Wrapper<SuppliesUonghuEntity> wrapper);
    List<SuppliesUonghuEntity> selectListView(Pagination page, @Param("ew") Wrapper<SuppliesUonghuEntity> wrapper);

    List<SuppliesYonghuVo> selectSuppliesYongView(@Param("ew") Wrapper<SuppliesUonghuEntity> wrapper);
    List<SuppliesYonghuVo> selectSuppliesYongView(Pagination page, @Param("ew") Wrapper<SuppliesUonghuEntity> wrapper);
}
