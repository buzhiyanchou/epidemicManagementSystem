package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.YongHuAddrEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface YongHuAddrDao extends BaseMapper<YongHuAddrEntity> {
    List<YongHuAddrEntity> selectListView(@Param("ew") Wrapper<YongHuAddrEntity> wrapper);
    List<YongHuAddrEntity> selectListView(Pagination page, @Param("ew") Wrapper<YongHuAddrEntity> wrapper);

    String getYonAddrByYongId(String yonghuId);

    void removeByYongHuIds(List<String> list);
}
