package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuruxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuruxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuruxinxiView;


/**
 * 出入信息
 *
 * @author 
 * @email 
 * @date 2022-03-10 14:25:06
 */
public interface ChuruxinxiService extends IService<ChuruxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuruxinxiVO> selectListVO(Wrapper<ChuruxinxiEntity> wrapper);
   	
   	ChuruxinxiVO selectVO(@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
   	
   	List<ChuruxinxiView> selectListView(Wrapper<ChuruxinxiEntity> wrapper);
   	
   	ChuruxinxiView selectView(@Param("ew") Wrapper<ChuruxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuruxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChuruxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChuruxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChuruxinxiEntity> wrapper);
}

