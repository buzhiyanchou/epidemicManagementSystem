package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.GoodsCartEntity;
import com.service.AreaService;
import com.service.GoodsCartService;
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
@RequestMapping("cart")
public class GoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, GoodsCartEntity entity){
        EntityWrapper<GoodsCartEntity> ew = new EntityWrapper<>();
        PageUtils page = goodsCartService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(GoodsCartEntity entity){
        EntityWrapper<GoodsCartEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "goods_cart"));
        return R.ok().put("data", goodsCartService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody GoodsCartEntity entity) {
        entity.setCreateTime(new Date());
        GoodsCartEntity goodsCartEntity = goodsCartService.selectOne(new EntityWrapper<GoodsCartEntity>().eq("yonghu_id", entity.getYonghuId()).and().eq("goods_id", entity.getGoodsId()));
        if(goodsCartEntity != null){
            goodsCartEntity.setGoodsNum((Integer.valueOf(goodsCartEntity.getGoodsNum()) + 1) + "");
            goodsCartService.updateById(goodsCartEntity);
        }else goodsCartService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody GoodsCartEntity entity) {
       /* GoodsCartEntity u = goodsCartService.selectOne(new EntityWrapper<GoodsCartEntity>().eq("area_name", entity.getAreaName()));
        if(u!=null && u.getId()!=entity.getId() && u.getAreaName().equals(entity.getAreaName())) {
            return R.error("用户名已存在。");
        }*/
        goodsCartService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        goodsCartService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/list/cart/{yonghuID}")
    public R getCartByYonghuId(@PathVariable("yonghuID") String yonghuID) {
        return R.ok().put("data", goodsCartService.getGoodsCartByYongHuId(yonghuID));
    }


}
