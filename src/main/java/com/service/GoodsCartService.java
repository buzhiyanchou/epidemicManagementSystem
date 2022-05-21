package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.AreaEntity;
import com.entity.GoodsCartEntity;
import com.entity.vo.GoodsCartVo;
import com.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:28
 **/


public interface GoodsCartService extends IService<GoodsCartEntity> {

    PageUtils queryPage(Map<String, Object> params);
    List<GoodsCartEntity> selectListView(Wrapper<GoodsCartEntity> wrapper);
    PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsCartEntity> wrapper);

    List<GoodsCartVo> getGoodsCartByYongHuId(String yonghuId);
}
