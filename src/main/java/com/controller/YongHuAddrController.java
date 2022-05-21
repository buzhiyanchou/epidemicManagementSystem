package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.YongHuAddrEntity;
import com.service.AreaService;
import com.service.YongHuAddrService;
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
@RequestMapping("addr")
public class YongHuAddrController {

    @Autowired
    private YongHuAddrService yongHuAddrService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YongHuAddrEntity entity){
        EntityWrapper<YongHuAddrEntity> ew = new EntityWrapper<>();
        PageUtils page = yongHuAddrService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(YongHuAddrEntity entity){
        EntityWrapper<YongHuAddrEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "yonghu_addr"));
        return R.ok().put("data", yongHuAddrService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody YongHuAddrEntity areaEntity) {
        if(yongHuAddrService.selectOne(new EntityWrapper<YongHuAddrEntity>().eq("yonghu_id", areaEntity.getYonghuId())) != null)
            return R.error("区域以存在");
        yongHuAddrService.insert(areaEntity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody YongHuAddrEntity entity) {
        /*YongHuAddrEntity u = yongHuAddrService.selectOne(new EntityWrapper<YongHuAddrEntity>().eq("yonghu_id", entity.getYonghuId()));
        if(u!=null && u.getId()!=entity.getId() && u.getYonghuId().equals(entity.getYonghuId())) {
            return R.error("住址以存在");
        }*/
        yongHuAddrService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        yongHuAddrService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/one/{yonghuId}")
    public R getYongHuAddrByYongHuId(@PathVariable("yonghuId") String yonghuId) {
        EntityWrapper<YongHuAddrEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("yonghu_id", yonghuId);
        return R.ok().put("data", yongHuAddrService.selectListView(wrapper));
    }

    @GetMapping("/str/{yonghuId}")
    public R getYonAddrStr(@PathVariable("yonghuId") String yonghuId){
        return R.ok().put("data", yongHuAddrService.getYonAddrByYongId(yonghuId));
    }

    @RequestMapping("/removeByyonhuIds")
    public R removeByYonghuIds(@RequestBody String[] ids){
        yongHuAddrService.removeByYongHuIds(Arrays.asList(ids));
        return R.ok();
    }
}
