package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.EpidemicLog;
import com.entity.vo.EpidemicLogVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EpidemicDao  extends BaseMapper<EpidemicLog> {


    EpidemicLog queryById(@Param("id") Long id);

    Integer selectCountInDay();

    List<EpidemicLogVo> queryPage(Integer page, Integer size);
}
