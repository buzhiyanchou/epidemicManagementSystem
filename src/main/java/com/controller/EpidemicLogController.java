package com.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.service.EpidemicService;
import com.service.YonghuService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/epidemic")
public class EpidemicLogController {

    @Autowired
    private EpidemicService epidemicService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, EpidemicLog epidemicLog,
                  HttpServletRequest request){

        EntityWrapper<EpidemicLog> ew = new EntityWrapper<EpidemicLog>();
//        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, epidemicLog), params), params));


        //一直爆红  检查不出来
//        PageUtils page = epidemicService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, epidemicLog), params), params));
//        return R.ok().put("data", page);
        // TODO: 2022/5/24 获取返回疫情记录表的数据   // 并能实现条件查询     需要将用户表中的 名字以及 status 连表查询返回
        return null;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EpidemicLog epidemicLog, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghu);

        // TODO: 2022/5/24 更改 先查询 id 是否存在  存在则更新  不存在则插入
//        epidemicService.updateById(epidemicLog);//全部更新
        return R.ok();
    }
}
