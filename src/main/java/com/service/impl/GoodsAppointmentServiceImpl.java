package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.GoodsAppointmentDao;
import com.entity.AreaEntity;
import com.entity.GoodsAppointmentAppEntity;
import com.entity.GoodsEntity;
import com.entity.vo.AppotinmentGoodsVo;
import com.service.AreaService;
import com.service.GoodsAppointmentService;
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
public class GoodsAppointmentServiceImpl extends ServiceImpl<GoodsAppointmentDao, GoodsAppointmentAppEntity> implements GoodsAppointmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsAppointmentAppEntity> page = this.selectPage(
                new Query<GoodsAppointmentAppEntity>(params).getPage(),
                new EntityWrapper<GoodsAppointmentAppEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<GoodsAppointmentAppEntity> selectListView(Wrapper<GoodsAppointmentAppEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsAppointmentAppEntity> wrapper) {
            Page<GoodsAppointmentAppEntity> page =new Query<GoodsAppointmentAppEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }

    @Override
    public List<AppotinmentGoodsVo> getGoodsAppointListByYongHuId(String yonghuId) {
        return baseMapper.getGoodsAppointListByYongHuId(yonghuId);
    }


}
