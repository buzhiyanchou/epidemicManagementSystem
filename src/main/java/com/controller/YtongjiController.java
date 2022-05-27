package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.entity.Ytongji;
import com.entity.view.YonghuView;
import com.entity.vo.YonghuVO;
import com.service.EpidemicService;
import com.service.YonghuService;
import com.utils.DateUtil;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ytongji")
public class YtongjiController {

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private EpidemicService epidemicService;

    /**
     * 后端列表
     */
    @GetMapping("/selectToalTongJi")
    public R selectToalTongJi() {
        //获取当日的日期
        Date date = new Date();
        Date startTime = DateUtil.getStartOfDay(date);
        Date endTime = DateUtil.getEndOfDay(date);
        Ytongji ytongji = new Ytongji();
        Integer zongrenshu = 0;
        Integer WzzNum = 0;
        Integer GlNum = 0;
        Integer ZyNum = 0;
        Integer QzNum = 0;
        Integer TodayAddNum = 0;
        Integer TodayWzzNum = 0;
        Integer TodayGlNum = 0;
        //用户表总人数
        List<YonghuVO> yonghuVOS = yonghuService.selectAll();
        if (!CollectionUtils.isEmpty(yonghuVOS)) {
            zongrenshu = yonghuVOS.size();
        }

        //隔离者总人数
        Wrapper<YonghuEntity> wrapper11 = new EntityWrapper<YonghuEntity>();
        wrapper11.eq("back_status", 1);
        List<YonghuView> yonghuViews21 = yonghuService.selectListView(wrapper11);
        if (!CollectionUtils.isEmpty(yonghuViews21)) {
            GlNum = yonghuViews21.size();
        }
        //自愈者总人数
        Wrapper<YonghuEntity> wrapper211 = new EntityWrapper<YonghuEntity>();
        wrapper211.eq("back_status", 2);
        List<YonghuView> yonghuViews121 = yonghuService.selectListView(wrapper211);
        if (!CollectionUtils.isEmpty(yonghuViews121)) {
            ZyNum = yonghuViews121.size();
        }
        //确诊总人数
        Wrapper<YonghuEntity> wrapper = new EntityWrapper<YonghuEntity>();
        wrapper.eq("status", 1);
        List<YonghuView> yonghuViews2 = yonghuService.selectListView(wrapper);
        if (!CollectionUtils.isEmpty(yonghuViews2)) {
            QzNum = yonghuViews2.size();
        }
        //确诊无症状感染总数
        Wrapper<YonghuEntity> wrapper89 = new EntityWrapper<YonghuEntity>();
        wrapper89.eq("status", 2);
        List<YonghuView> yonghuViews29 = yonghuService.selectListView(wrapper89);
        if (!CollectionUtils.isEmpty(yonghuViews29)) {
            WzzNum = yonghuViews29.size();
        }

        //今日新增人数
        Wrapper<EpidemicLog> wrapper110 = new EntityWrapper<EpidemicLog>();
        wrapper110.gt("qz_time", startTime);
        wrapper110.lt("qz_time", endTime);
        List<EpidemicLog> yonghuViews2111 = epidemicService.selectListView(wrapper110);
        if (!CollectionUtils.isEmpty(yonghuViews2111)) {
            TodayAddNum = yonghuViews2111.size();
        }
        //今日无症状人数
        Wrapper<EpidemicLog> wrapper1 = new EntityWrapper<EpidemicLog>();
        wrapper1.gt("wzz_time", startTime);
        wrapper1.lt("wzz_time", endTime);
        List<EpidemicLog> yonghuViews1 = epidemicService.selectListView(wrapper1);
        if (!CollectionUtils.isEmpty(yonghuViews1)) {
            TodayWzzNum = yonghuViews1.size();
        }
        //今日隔离
        Wrapper<EpidemicLog> wrapper14 = new EntityWrapper<EpidemicLog>();
        wrapper14.gt("gl_time", startTime);
        wrapper14.lt("gl_time", endTime);
        List<EpidemicLog> yonghuViews212 = epidemicService.selectListView(wrapper14);
        if (!CollectionUtils.isEmpty(yonghuViews212)) {
            TodayGlNum = yonghuViews212.size();
        }
        //总人数
        ytongji.setAllNum(zongrenshu);
        //无症状感染人数
        ytongji.setWzzNum(WzzNum);
        //现已隔离
        ytongji.setAllGlNum(GlNum);
        //今日隔离
        ytongji.setTodayGlNum(TodayGlNum);
        //已治愈
        ytongji.setZyNum(ZyNum);
        //累计确诊
        ytongji.setAllQzNum(QzNum);
        //今日新增
        ytongji.setTodayAddNum(TodayAddNum);
        //今日新增无症状
        ytongji.setTodayWzzNum(TodayWzzNum);
        //今日新增隔离

        return R.ok().put("data", ytongji);
    }

}
