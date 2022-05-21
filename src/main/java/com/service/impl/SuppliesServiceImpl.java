package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.SuppliesDao;
import com.entity.AreaEntity;
import com.entity.SuppliesEntity;
import com.service.AreaService;
import com.service.SuppliesService;
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
public class SuppliesServiceImpl extends ServiceImpl<SuppliesDao, SuppliesEntity> implements SuppliesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SuppliesEntity> page = this.selectPage(
                new Query<SuppliesEntity>(params).getPage(),
                new EntityWrapper<SuppliesEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<SuppliesEntity> selectListView(Wrapper<SuppliesEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<SuppliesEntity> wrapper) {
            Page<SuppliesEntity> page =new Query<SuppliesEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }


}
