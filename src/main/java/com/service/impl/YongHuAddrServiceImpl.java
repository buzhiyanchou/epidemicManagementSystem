package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.YongHuAddrDao;
import com.entity.AreaEntity;
import com.entity.YongHuAddrEntity;
import com.service.AreaService;
import com.service.YongHuAddrService;
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
public class YongHuAddrServiceImpl extends ServiceImpl<YongHuAddrDao, YongHuAddrEntity> implements YongHuAddrService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YongHuAddrEntity> page = this.selectPage(
                new Query<YongHuAddrEntity>(params).getPage(),
                new EntityWrapper<YongHuAddrEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<YongHuAddrEntity> selectListView(Wrapper<YongHuAddrEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YongHuAddrEntity> wrapper) {
            Page<YongHuAddrEntity> page =new Query<YongHuAddrEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }

    @Override
    public String getYonAddrByYongId(String yonghuId) {
        return baseMapper.getYonAddrByYongId(yonghuId);
    }

    @Override
    public void removeByYongHuIds(List<String> yonghuIds) {
        baseMapper.removeByYongHuIds(yonghuIds);
    }


}
