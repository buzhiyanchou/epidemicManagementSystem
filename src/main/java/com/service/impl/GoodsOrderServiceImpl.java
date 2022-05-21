package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.GoodsOrderDao;
import com.entity.AreaEntity;
import com.entity.GoodsOrderEntity;
import com.entity.vo.GoodsOrderVo;
import com.service.AreaService;
import com.service.GoodsOrderService;
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
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderDao, GoodsOrderEntity> implements GoodsOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsOrderEntity> page = this.selectPage(
                new Query<GoodsOrderEntity>(params).getPage(),
                new EntityWrapper<GoodsOrderEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<GoodsOrderEntity> selectListView(Wrapper<GoodsOrderEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsOrderEntity> wrapper) {
            Page<GoodsOrderEntity> page =new Query<GoodsOrderEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }

    @Override
    public List<GoodsOrderVo> getGoodsOrderList(String yonghuId) {
        return baseMapper.getGoodsOrderList(yonghuId);
    }


}
