package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.GoodsEntity;
import com.service.AreaService;
import com.service.GoodsService;
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
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GoodsEntity entity){
        EntityWrapper<GoodsEntity> ew = new EntityWrapper<>();
        PageUtils page = goodsService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(GoodsEntity entity){
        EntityWrapper<GoodsEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "goods"));
        return R.ok().put("data", goodsService.selectListView(ew));
    }


    @PostMapping("/save")
    public R save(@RequestBody GoodsEntity entity) {
        entity.setCreateTime(new Date());
        /*if(goodsService.selectOne(new EntityWrapper<AreaEntity>().eq("area_name", entity.getAreaName())) != null)
            return R.error("区域以存在");*/
        goodsService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody GoodsEntity entity) {
        entity.setUpdateTime(new Date());
        /*AreaEntity u = goodsService.selectOne(new EntityWrapper<AreaEntity>().eq("area_name", entity.getAreaName()));
        if(u!=null && u.getId()!=entity.getId() && u.getAreaName().equals(entity.getAreaName())) {
            return R.error("用户名已存在。");
        }*/
        goodsService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        goodsService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/list/has/{typeId}")
    public R getHasGoods(@PathVariable("typeId") String typeId) {
        return R.ok().put("data", goodsService.getHasGoodsListByTypeId(typeId));
    }
}
