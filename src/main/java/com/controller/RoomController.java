package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AreaEntity;
import com.entity.RoomEntity;
import com.service.AreaService;
import com.service.RoomService;
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
    @RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params, RoomEntity entity){
        EntityWrapper<RoomEntity> ew = new EntityWrapper<>();
        PageUtils page = roomService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.allLike(ew, entity), params), params));
        return R.ok().put("data", page);
    }

    @GetMapping("/list")
    public R list(RoomEntity entity){
        EntityWrapper<RoomEntity> ew = new EntityWrapper<>();
        ew.allEq(MPUtil.allEQMapPre( entity, "room"));
        return R.ok().put("data", roomService.selectListView(ew));
    }

    @PostMapping("/save")
    public R save(@RequestBody RoomEntity entity) {
        entity.setCreateTime(new Date());
        if(roomService.selectOne(new EntityWrapper<RoomEntity>().eq("room_num", entity.getRoomNum())) != null)
            return R.error("区域以存在");
        roomService.insert(entity);
        return R.ok();
    }

    @RequestMapping("/update")
    public R update(@RequestBody RoomEntity entity) {
        entity.setUpdateTime(new Date());
        RoomEntity u = roomService.selectOne(new EntityWrapper<RoomEntity>().eq("room_num", entity.getRoomNum()));
        if(u!=null && u.getId()!=entity.getId() && u.getRoomNum().equals(entity.getRoomNum())) {
            return R.error("用户名已存在。");
        }
        roomService.updateById(entity);
        return R.ok();
    }

    @RequestMapping("/remove")
    public R remove(@RequestBody Long[] ids){
        roomService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
