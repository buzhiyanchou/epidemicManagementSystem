package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.LocationInfoDao;
import com.entity.AreaEntity;
import com.entity.LocationInfoEntity;
import com.service.AreaService;
import com.service.LocationInfoService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:30
 **/
@Service
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoDao, LocationInfoEntity> implements LocationInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LocationInfoEntity> page = this.selectPage(
                new Query<LocationInfoEntity>(params).getPage(),
                new EntityWrapper<LocationInfoEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<LocationInfoEntity> selectListView(Wrapper<LocationInfoEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<LocationInfoEntity> wrapper) {
            Page<LocationInfoEntity> page =new Query<LocationInfoEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }

    @Override
    public List<LocationInfoEntity> getLocationInfoByYonghuId(String yonghuId) {
        return baseMapper.getLocationInfoByYonghuId(yonghuId);
    }


}
