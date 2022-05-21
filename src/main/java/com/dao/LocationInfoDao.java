package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.LocationInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/25 20:15
 **/

public interface LocationInfoDao extends BaseMapper<LocationInfoEntity> {

    List<LocationInfoEntity> selectListView(@Param("ew") Wrapper<LocationInfoEntity> wrapper);
    List<LocationInfoEntity> selectListView(Pagination page, @Param("ew") Wrapper<LocationInfoEntity> wrapper);
    List<LocationInfoEntity> getLocationInfoByYonghuId(String yonghuId);
}
