package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.GoodsTypeDao;
import com.entity.AreaEntity;
import com.entity.GoodsTypeEntity;
import com.service.AreaService;
import com.service.GoodsTypeService;
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
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeDao, GoodsTypeEntity> implements GoodsTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsTypeEntity> page = this.selectPage(
                new Query<GoodsTypeEntity>(params).getPage(),
                new EntityWrapper<GoodsTypeEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<GoodsTypeEntity> selectListView(Wrapper<GoodsTypeEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsTypeEntity> wrapper) {
            Page<GoodsTypeEntity> page =new Query<GoodsTypeEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }


}
