package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.LocationInfoEntity;
import com.service.AreaService;
import com.service.LocationInfoService;
import com.utils.DateUtil;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:39
 **/

@RestController
@RequestMapping("location")
public class LocationInfoController {

    @Autowired
    private LocationInfoService locationInfoService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, LocationInfoEntity entity){
        EntityWrapper<AreaEntity> ew = new EntityWrapper<>();
        PageUtils page = locationInfoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(LocationInfoEntity entity){
        EntityWrapper<LocationInfoEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "location"));
        return R.ok().put("data", locationInfoService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody LocationInfoEntity entity) {
        entity.setCreateTime(new Date());

        Date start = DateUtil.strToDateLong(DateUtil.dateToStr(new Date(), Locale.CHINA) + " 00:00:00");
        Date end = DateUtil.strToDateLong(DateUtil.dateToStr(new Date(), Locale.CHINA) + " 23:59:59");

        EntityWrapper<LocationInfoEntity> wrapper = new EntityWrapper<>();

        /*SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String  endTime = sDateFormat.format(new Date());
        String beginTime = endTime.split(" ")[0];
        wrapper.ge("create_time", beginTime).le("create_time", endTime);*/

        wrapper.between("create_time", start, end).and().eq("yonghu_id", entity.getYonghuId());
        LocationInfoEntity tempEntity = locationInfoService.selectOne(wrapper);
        System.out.println(tempEntity);
        if(tempEntity != null) {
            locationInfoService.updateById(entity);
        }else locationInfoService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody LocationInfoEntity entity) {
        locationInfoService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        locationInfoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @GetMapping("/listBy/{yonghuId}")
    public R getLocationByYonghuId(@PathVariable("yonghuId") String yonghuId) {
        return R.ok().put("data", locationInfoService.selectList(new EntityWrapper<LocationInfoEntity>().eq("yonghu_id", yonghuId)));
    }
}
