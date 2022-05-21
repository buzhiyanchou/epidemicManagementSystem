package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.SuppliesUonghuEntity;
import com.entity.vo.SuppliesYonghuVo;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface SuppliesYonghuService extends IService<SuppliesUonghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<SuppliesUonghuEntity> selectListView(Wrapper<SuppliesUonghuEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<SuppliesUonghuEntity> wrapper);


    PageUtils querySuppliesApplyPage(Map<String, Object> params, Wrapper<SuppliesUonghuEntity> wrapper);
    List<SuppliesYonghuVo> selectSuppliesYongView(Wrapper<SuppliesUonghuEntity> wrapper);
}
