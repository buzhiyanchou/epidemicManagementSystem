package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.entity.Ytongji;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/ytongji")
public class YtongjiController {


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(){
        // TODO: 2022/5/24 查询返回 Ytongji 对象
//        return R.ok().put("data", data);
        return null;
    }


}
