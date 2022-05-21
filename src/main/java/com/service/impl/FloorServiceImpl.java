package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.FloorDao;
import com.entity.AreaEntity;
import com.entity.FloorEntity;
import com.service.FloorService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/25 10:14
 **/
@Service
public class FloorServiceImpl extends ServiceImpl<FloorDao, FloorEntity> implements FloorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FloorEntity> page = this.selectPage(
                new Query<FloorEntity>(params).getPage(),
                new EntityWrapper<FloorEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<FloorEntity> selectListView(Wrapper<FloorEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<FloorEntity> wrapper) {
        Page<FloorEntity> page =new Query<FloorEntity>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

}
