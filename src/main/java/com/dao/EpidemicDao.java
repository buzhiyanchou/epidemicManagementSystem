package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.entity.view.YonghuView;
import com.entity.vo.EpidemicLogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EpidemicDao  extends BaseMapper<EpidemicLog> {


    EpidemicLog queryById(@Param("id") Long id);

    Integer selectCountInDay();
    List<EpidemicLog> selectListView(@Param("ew") Wrapper<EpidemicLog> wrapper);
    List<EpidemicLogVo> queryPage(Integer page, Integer size);
}
