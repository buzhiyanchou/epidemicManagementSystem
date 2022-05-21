package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.ForeignPersonnelEntity;
import com.service.AreaService;
import com.service.ForeignPersonnelService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:39
 **/

@RestController
@RequestMapping("foreign_personnel")
public class ForeignPersonnelController {

    @Autowired
    private ForeignPersonnelService foreignPersonnelService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ForeignPersonnelEntity entity){
        EntityWrapper<ForeignPersonnelEntity> ew = new EntityWrapper<>();
//        PageUtils page = foreignPersonnelService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        if(!StringUtils.isEmpty(entity.getEndTime()) && !StringUtils.isEmpty(entity.getStartTime())){
            ew.le("end_time", entity.getEndTime());
            ew.ge("start_timegt", entity.getStartTime());
        }
        if(!StringUtils.isEmpty(entity.getName())){
            ew.eq("name", entity.getName());
        }
        PageUtils page = foreignPersonnelService.queryPage(params, ew);
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(ForeignPersonnelEntity entity){
        EntityWrapper<ForeignPersonnelEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "area"));
        return R.ok().put("data", foreignPersonnelService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody ForeignPersonnelEntity entity) {
        entity.setCreateTime(new Date());
        foreignPersonnelService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody ForeignPersonnelEntity entity) {
        entity.setUpdateTime(new Date());
        foreignPersonnelService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        foreignPersonnelService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
