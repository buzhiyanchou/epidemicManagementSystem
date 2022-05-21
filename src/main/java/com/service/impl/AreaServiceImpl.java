package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.entity.AreaEntity;
import com.entity.UserEntity;
import com.service.AreaService;
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
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AreaEntity> page = this.selectPage(
                new Query<AreaEntity>(params).getPage(),
                new EntityWrapper<AreaEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<AreaEntity> selectListView(Wrapper<AreaEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<AreaEntity> wrapper) {
            Page<AreaEntity> page =new Query<AreaEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }


}
