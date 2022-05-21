package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.SuppliesEntity;
import com.service.AreaService;
import com.service.SuppliesService;
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
@RequestMapping("supplies")
public class SuppliesController {

    @Autowired
    private SuppliesService suppliesService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, SuppliesEntity entity){
        EntityWrapper<SuppliesEntity> ew = new EntityWrapper<>();
        PageUtils page = suppliesService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(SuppliesEntity entity){
        EntityWrapper<SuppliesEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "supplies"));
        return R.ok().put("data", suppliesService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody SuppliesEntity areaEntity) {
        areaEntity.setCreateTime(new Date());
        if(suppliesService.selectOne(new EntityWrapper<SuppliesEntity>().eq("name", areaEntity.getName())) != null)
            return R.error("区域以存在");
        suppliesService.insert(areaEntity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody SuppliesEntity entity) {
        entity.setUpdateTime(new Date());
        SuppliesEntity u = suppliesService.selectOne(new EntityWrapper<SuppliesEntity>().eq("name", entity.getName()));
        if(u!=null && u.getId()!=entity.getId() && u.getName().equals(entity.getName())) {
            return R.error("用户名已存在。");
        }
        suppliesService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        suppliesService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
