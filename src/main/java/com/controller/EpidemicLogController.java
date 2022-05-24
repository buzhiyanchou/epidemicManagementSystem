package com.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.entity.vo.YonghuVO;
import com.service.EpidemicService;
import com.service.YonghuService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/epidemic")
public class EpidemicLogController {

    @Autowired
    private EpidemicService epidemicService;
    @Autowired
    private YonghuService yonghuService;
    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, EpidemicLog epidemicLog,
                  HttpServletRequest request){

        EntityWrapper<EpidemicLog> ew = new EntityWrapper<EpidemicLog>();
//        PageUtils page = yonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, epidemicLog), params), params));
        //一直爆红  检查不出来  Fixed 参数类型个数不一致
        PageUtils page = epidemicService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, epidemicLog), params), params));
//        return R.ok().put("data", page);
        //用户名map<id,name>
        Map<Integer, String> userMap = yonghuService.selectAll().stream().collect(Collectors.toMap(YonghuVO::getId, YonghuVO -> YonghuVO.getXingming()));

        List<EpidemicLog> list = (List<EpidemicLog>) page.getList();
        list.forEach(e->{
          e.setName(userMap.get(e.getId()));
        });
        // TODO: 2022/5/24 获取返回疫情记录表的数据   // 并能实现条件查询     需要将用户表中的 名字以及 status 连表查询返回
        return null;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody @Valid EpidemicLog epidemicLog, HttpServletRequest request){
//        ValidatorUtils.validateEntity(yonghu);
        // TODO: 2022/5/24 更改 先查询 id 是否存在  存在则更新  不存在则插入
        EpidemicLog log = epidemicService.selectById(epidemicLog.getId());
        if (Objects.nonNull(log)){
            //全部更新   前端要传全数值不然为null也会更新字段
            epidemicService.updateById(epidemicLog);
        }else{
            epidemicService.insert(epidemicLog);
        }
        return R.ok();
    }
}
