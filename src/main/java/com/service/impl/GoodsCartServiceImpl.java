package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.AreaDao;
import com.dao.GoodsCartDao;
import com.entity.AreaEntity;
import com.entity.GoodsCartEntity;
import com.entity.vo.GoodsCartVo;
import com.service.AreaService;
import com.service.GoodsCartService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:30
 **/
@Service
public class GoodsCartServiceImpl extends ServiceImpl<GoodsCartDao, GoodsCartEntity> implements GoodsCartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsCartEntity> page = this.selectPage(
                new Query<GoodsCartEntity>(params).getPage(),
                new EntityWrapper<GoodsCartEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<GoodsCartEntity> selectListView(Wrapper<GoodsCartEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodsCartEntity> wrapper) {
            Page<GoodsCartEntity> page =new Query<GoodsCartEntity>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,wrapper));
            PageUtils pageUtil = new PageUtils(page);
            return pageUtil;
    }

    @Override
    public List<GoodsCartVo> getGoodsCartByYongHuId(String yonghuId) {
        return baseMapper.getGoodsCartByYongHuId(yonghuId);
    }


}
