package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.RoomDao;
import com.entity.AreaEntity;
import com.entity.RoomEntity;
import com.service.AreaService;
import com.service.RoomService;
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
public class RoomServiceImpl extends ServiceImpl<RoomDao, RoomEntity> implements RoomService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RoomEntity> page = this.selectPage(
                new Query<RoomEntity>(params).getPage(),
                new EntityWrapper<RoomEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<RoomEntity> selectListView(Wrapper<RoomEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<RoomEntity> wrapper) {
            Page<RoomEntity> page =new Query<RoomEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }


}
