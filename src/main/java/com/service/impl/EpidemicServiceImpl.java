package com.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.EpidemicDao;
import com.entity.ConfigEntity;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.service.ConfigService;
import com.service.EpidemicService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("epidemicService")
public class EpidemicServiceImpl extends ServiceImpl<EpidemicDao, EpidemicLog> implements EpidemicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EpidemicLog> page = this.selectPage(
                new Query<EpidemicLog>(params).getPage(),
                new EntityWrapper<EpidemicLog>()
        );
        return new PageUtils(page);
    }
}
