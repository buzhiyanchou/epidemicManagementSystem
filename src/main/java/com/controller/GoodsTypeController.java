package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.GoodsTypeEntity;
import com.service.AreaService;
import com.service.GoodsTypeService;
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
@RequestMapping("goods/type")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GoodsTypeEntity entity){
        EntityWrapper<GoodsTypeEntity> ew = new EntityWrapper<>();
        PageUtils page = goodsTypeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(GoodsTypeEntity entity){
        EntityWrapper<GoodsTypeEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "goods_type"));
        return R.ok().put("data", goodsTypeService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody GoodsTypeEntity entity) {
        entity.setCreateTime(new Date());
        if(goodsTypeService.selectOne(new EntityWrapper<GoodsTypeEntity>().eq("type_name", entity.getTypeName())) != null)
            return R.error("分类以存在");
        goodsTypeService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody GoodsTypeEntity entity) {
        entity.setUpdateTime(new Date());
        GoodsTypeEntity u = goodsTypeService.selectOne(new EntityWrapper<GoodsTypeEntity>().eq("type_name", entity.getTypeName()));
        if(u!=null && u.getId()!=entity.getId() && u.getTypeName().equals(entity.getTypeName())) {
            return R.error("分类以存在。");
        }
        goodsTypeService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        goodsTypeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
