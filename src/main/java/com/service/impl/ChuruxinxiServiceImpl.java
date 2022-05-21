package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChuruxinxiDao;
import com.entity.ChuruxinxiEntity;
import com.service.ChuruxinxiService;
import com.entity.vo.ChuruxinxiVO;
import com.entity.view.ChuruxinxiView;

@Service("churuxinxiService")
public class ChuruxinxiServiceImpl extends ServiceImpl<ChuruxinxiDao, ChuruxinxiEntity> implements ChuruxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuruxinxiEntity> page = this.selectPage(
                new Query<ChuruxinxiEntity>(params).getPage(),
                new EntityWrapper<ChuruxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuruxinxiEntity> wrapper) {
		  Page<ChuruxinxiView> page =new Query<ChuruxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChuruxinxiVO> selectListVO(Wrapper<ChuruxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuruxinxiVO selectVO(Wrapper<ChuruxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuruxinxiView> selectListView(Wrapper<ChuruxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuruxinxiView selectView(Wrapper<ChuruxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChuruxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChuruxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChuruxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

}
