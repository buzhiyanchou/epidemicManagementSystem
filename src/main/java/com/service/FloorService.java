package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.dao.FloorDao;
import com.entity.AreaEntity;
import com.entity.FloorEntity;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/25 10:14
 **/


public interface FloorService extends IService<FloorEntity> {
    PageUtils queryPage(Map<String, Object> params);
    List<FloorEntity> selectListView(Wrapper<FloorEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params,Wrapper<FloorEntity> wrapper);

}
