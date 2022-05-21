package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.SuppliesEntity;
import com.entity.SuppliesUonghuEntity;
import com.service.AreaService;
import com.service.SuppliesService;
import com.service.SuppliesYonghuService;
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
@RequestMapping("supplies_yonghu")
public class SuppliesYonghuController {

    @Autowired
    private SuppliesYonghuService suppliesYonghuService;
    @Autowired
    private SuppliesService suppliesService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, SuppliesUonghuEntity entity){
        EntityWrapper<SuppliesUonghuEntity> ew = new EntityWrapper<>();
        PageUtils page = suppliesYonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(SuppliesUonghuEntity entity){
        EntityWrapper<SuppliesUonghuEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "supplies_yonghu"));
        return R.ok().put("data", suppliesYonghuService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody SuppliesUonghuEntity entity) {
        entity.setCreateTime(new Date());
        SuppliesUonghuEntity tempEntity = suppliesYonghuService.selectOne(new EntityWrapper<SuppliesUonghuEntity>().eq("yonghu_id", entity.getYonghuId()).and().eq("supplies_id", entity.getSuppliesId()));
        if(tempEntity != null){
            Integer tempCount = Integer.valueOf(tempEntity.getSubscribeCount()) + 1;
            tempEntity.setSubscribeCount(tempCount + "");
            suppliesYonghuService.updateById(tempEntity);
        }else suppliesYonghuService.insert(entity);

        SuppliesEntity suppliesEntity = suppliesService.selectById(entity.getSuppliesId());
        if(suppliesEntity.getInventory() > 0){
            suppliesEntity.setInventory(suppliesEntity.getInventory() -1);
            suppliesService.updateById(suppliesEntity);
        }else return R.error("没有库存啦");

        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody SuppliesUonghuEntity entity) {
       /* SuppliesUonghuEntity u = suppliesYonghuService.selectOne(new EntityWrapper<SuppliesUonghuEntity>().eq("yonghu_id", entity.getYonghuId()));
        if(u!=null && u.getId()!=entity.getId() && u.getYonghuId().equals(entity.getYonghuId())) {
            return R.error("用户名已存在。");
        }*/
        suppliesYonghuService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        suppliesYonghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/apply/page")
    public R getSuppliesApplyPage(@RequestParam Map<String, Object> params, SuppliesUonghuEntity entity){
        EntityWrapper<SuppliesUonghuEntity> ew = new EntityWrapper<>();
        PageUtils page = suppliesYonghuService.querySuppliesApplyPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }
}
