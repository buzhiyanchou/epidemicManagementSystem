package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.GoodsAppointmentAppEntity;
import com.service.AreaService;
import com.service.GoodsAppointmentService;
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
@RequestMapping("appointment")
public class GoodsAppointmentController {

    @Autowired
    private GoodsAppointmentService goodsAppointmentService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GoodsAppointmentAppEntity entity){
        EntityWrapper<GoodsAppointmentAppEntity> ew = new EntityWrapper<>();
        PageUtils page = goodsAppointmentService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(GoodsAppointmentAppEntity entity){
        EntityWrapper<GoodsAppointmentAppEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "goods_appointment"));
        return R.ok().put("data", goodsAppointmentService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody GoodsAppointmentAppEntity entity) {
        GoodsAppointmentAppEntity tempEntity = goodsAppointmentService.selectOne(new EntityWrapper<GoodsAppointmentAppEntity>().eq("yonghu_id", entity.getYonghuId()).and().eq("goods_id", entity.getGoodsId()));
        if(tempEntity != null){
            /*Integer tempCount = Integer.valueOf(tempEntity.getAppointmentCount()) + 1;
            tempEntity.setAppointmentCount(tempCount+"");*/
            return R.error("您已预约");
        }
        goodsAppointmentService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody GoodsAppointmentAppEntity entity) {
        /*entity.setUpdateTime(new Date());
        AreaEntity u = goodsAppointmentService.selectOne(new EntityWrapper<AreaEntity>().eq("area_name", entity.getAreaName()));
        if(u!=null && u.getId()!=entity.getId() && u.getAreaName().equals(entity.getAreaName())) {
            return R.error("用户名已存在。");
        }*/
        goodsAppointmentService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        goodsAppointmentService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/goods/{yognhuId}")
    public R getAppointmentGoods(@PathVariable("yognhuId") String yognhuId) {
        return R.ok().put("data", goodsAppointmentService.getGoodsAppointListByYongHuId(yognhuId));
    }
}
