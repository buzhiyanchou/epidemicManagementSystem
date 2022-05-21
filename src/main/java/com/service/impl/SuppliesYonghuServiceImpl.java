package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.SuppliesYonghuDao;
import com.entity.AreaEntity;
import com.entity.SuppliesUonghuEntity;
import com.entity.vo.SuppliesYonghuVo;
import com.service.AreaService;
import com.service.SuppliesYonghuService;
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
public class SuppliesYonghuServiceImpl extends ServiceImpl<SuppliesYonghuDao, SuppliesUonghuEntity> implements SuppliesYonghuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SuppliesUonghuEntity> page = this.selectPage(
                new Query<SuppliesUonghuEntity>(params).getPage(),
                new EntityWrapper<SuppliesUonghuEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<SuppliesUonghuEntity> selectListView(Wrapper<SuppliesUonghuEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<SuppliesUonghuEntity> wrapper) {
            Page<SuppliesUonghuEntity> page =new Query<SuppliesUonghuEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }


    @Override
    public PageUtils querySuppliesApplyPage(Map<String, Object> params, Wrapper<SuppliesUonghuEntity> wrapper) {
        Page<SuppliesYonghuVo> page =new Query<SuppliesYonghuVo>(params).getPage();
        page.setRecords(baseMapper.selectSuppliesYongView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<SuppliesYonghuVo> selectSuppliesYongView(Wrapper<SuppliesUonghuEntity> wrapper) {
        return baseMapper.selectSuppliesYongView(wrapper);
    }


}
