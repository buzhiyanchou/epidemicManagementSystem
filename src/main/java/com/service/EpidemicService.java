package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ConfigEntity;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.EpidemicLogVo;
import com.utils.PageUtils;
import java.util.List;
import java.util.Map;


public interface EpidemicService extends IService<EpidemicLog> {

    PageUtils queryPage(Map<String, Object> params,Wrapper<ConfigEntity> wrapper);

    Integer selectCountInDay();

    EpidemicLog getById(Long id);

    List<EpidemicLogVo> queryPage(Integer page, Integer size);
    List<EpidemicLog> selectListView(Wrapper<EpidemicLog> wrapper);
}
