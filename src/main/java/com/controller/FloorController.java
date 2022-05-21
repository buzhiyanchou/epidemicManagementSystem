package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.FloorEntity;
import com.service.AreaService;
import com.service.FloorService;
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
 * @Date 2022/4/25 10:16
 **/

@CrossOrigin
@RequestMapping("floor")
@RestController
public class FloorController {

    @Autowired
    private FloorService floorService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, FloorEntity entity){
        EntityWrapper<FloorEntity> ew = new EntityWrapper<>();
        PageUtils page = floorService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(FloorEntity entity){
        EntityWrapper<FloorEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "floor"));
        return R.ok().put("data", floorService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody FloorEntity entity) {
        entity.setCreateTime(new Date());
        if(floorService.selectOne(new EntityWrapper<FloorEntity>().eq("floor_num", entity.getFloorNum())) != null)
            return R.error("区域以存在");
        floorService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody FloorEntity entity) {
        entity.setUpdateTime(new Date());
        FloorEntity u = floorService.selectOne(new EntityWrapper<FloorEntity>().eq("floor_num", entity.getFloorNum()));
        if(u!=null && u.getId()!=entity.getId() && u.getFloorNum().equals(entity.getFloorNum())) {
            return R.error("用户名已存在。");
        }
        floorService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        floorService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
