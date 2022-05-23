package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.EpidemicLog;
import com.entity.ForeignPersonnelEntity;
import com.entity.YonghuEntity;
import com.entity.Ytongji;
import com.service.EpidemicService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/ytongji")
public class YtongjiController {
@Autowired
private EpidemicService epidemicService;
    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(){
        Ytongji ytongji = new Ytongji();
        //总人数
        EntityWrapper<EpidemicLog> ew = new EntityWrapper<>();
        int i = epidemicService.selectCount(ew);
        ytongji.setAllNum(i);
        //无症状感染人数
        ytongji.setAllNum();
        //现已隔离
        ytongji.setAllNum();
        //已治愈
        ytongji.setAllNum();
        //累计确诊
        ytongji.setAllNum();
        //今日新增
        epidemicService.selectCountInDay()
        ytongji.setAllNum();
        //今日新增无症状
        ytongji.setAllNum();
        //今日新增隔离
        ytongji.setAllNum();
        // TODO: 2022/5/24 查询返回 Ytongji 对象
//        return R.ok().put("data", data);
        return R.ok().put("data", ytongji);
    }

}
