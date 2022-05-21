package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.GoodsOrderEntity;
import com.entity.YongHuAddrEntity;
import com.service.AreaService;
import com.service.GoodsOrderService;
import com.utils.CommonUtil;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:39
 **/

@RestController
@RequestMapping("order")
public class GoodsOrderController {

    @Autowired
    private GoodsOrderService goodsOrderService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GoodsOrderEntity entity){
        EntityWrapper<AreaEntity> ew = new EntityWrapper<>();
        PageUtils page = goodsOrderService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(GoodsOrderEntity entity){
        EntityWrapper<GoodsOrderEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "goods_order"));
        return R.ok().put("data", goodsOrderService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody GoodsOrderEntity entity) {
        entity.setCreateTime(new Date());
        entity.setOrderNum(UUID.randomUUID().toString());
        /*GoodsOrderEntity tempOrderEntity = goodsOrderService.selectOne(new EntityWrapper<GoodsOrderEntity>().eq("yonghu_id", entity.getYonghuId()).and().eq("goods_id", entity.getGoodsId()));
        if(tempOrderEntity != null){
            tempOrderEntity.setOrderNum(());
        }*/
        goodsOrderService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody GoodsOrderEntity entity) {
        goodsOrderService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        goodsOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/by/{yonghuId}")
    public R getGoodsOrder(@PathVariable("yonghuId") String yonghuId) {
        return R.ok().put("data", goodsOrderService.getGoodsOrderList(yonghuId));
    }
}
