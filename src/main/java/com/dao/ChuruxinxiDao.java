package com.dao;

import com.entity.ChuruxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuruxinxiVO;
import com.entity.view.ChuruxinxiView;


/**
 * 出入信息
 * 
 * @author 
 * @email 
 * @date 2022-03-10 14:25:06
 */
public interface ChuruxinxiDao extends BaseMapper<ChuruxinxiEntity> {
	
	List<ChuruxinxiVO> selectListVO(@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
	
	ChuruxinxiVO selectVO(@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
	
	List<ChuruxinxiView> selectListView(@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);

	List<ChuruxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
	
	ChuruxinxiView selectView(@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
}
