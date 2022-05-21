package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.UserEntity;
import com.service.AreaService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:39
 **/

@RestController
@RequestMapping("area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, AreaEntity entity){
        EntityWrapper<AreaEntity> ew = new EntityWrapper<>();
        PageUtils page = areaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(AreaEntity entity){
        EntityWrapper<AreaEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "area"));
        return R.ok().put("data", areaService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody AreaEntity areaEntity) {
        areaEntity.setCreateTime(new Date());
        if(areaService.selectOne(new EntityWrapper<AreaEntity>().eq("area_name", areaEntity.getAreaName())) != null)
            return R.error("区域以存在");
        areaService.insert(areaEntity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody AreaEntity entity) {
        entity.setUpdateTime(new Date());
        AreaEntity u = areaService.selectOne(new EntityWrapper<AreaEntity>().eq("area_name", entity.getAreaName()));
        if(u!=null && u.getId()!=entity.getId() && u.getAreaName().equals(entity.getAreaName())) {
            return R.error("用户名已存在。");
        }
        areaService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        areaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
