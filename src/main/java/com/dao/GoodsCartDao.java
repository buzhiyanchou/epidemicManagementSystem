package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.AreaEntity;
import com.entity.GoodsCartEntity;
import com.entity.vo.GoodsCartVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 3fes
 * @Date 2022/4/24 23:22
 **/


public interface GoodsCartDao extends BaseMapper<GoodsCartEntity> {
    List<GoodsCartEntity> selectListView(@Param("ew") Wrapper<GoodsCartEntity> wrapper);
    List<GoodsCartEntity> selectListView(Pagination page, @Param("ew") Wrapper<GoodsCartEntity> wrapper);

    List<GoodsCartVo> getGoodsCartByYongHuId(String yonghuId);

}
