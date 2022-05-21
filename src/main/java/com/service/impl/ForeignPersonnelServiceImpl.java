package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.ForeignPersonnelDao;
import com.entity.AreaEntity;
import com.entity.ForeignPersonnelEntity;
import com.service.AreaService;
import com.service.ForeignPersonnelService;
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
public class ForeignPersonnelServiceImpl extends ServiceImpl<ForeignPersonnelDao, ForeignPersonnelEntity> implements ForeignPersonnelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ForeignPersonnelEntity> page = this.selectPage(
                new Query<ForeignPersonnelEntity>(params).getPage(),
                new EntityWrapper<ForeignPersonnelEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<ForeignPersonnelEntity> selectListView(Wrapper<ForeignPersonnelEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ForeignPersonnelEntity> wrapper) {
            Page<ForeignPersonnelEntity> page =new Query<ForeignPersonnelEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }


}
