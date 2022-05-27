package com.service.impl;

import com.entity.EpidemicLog;
import com.service.EpidemicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YonghuDao;
import com.entity.YonghuEntity;
import com.service.YonghuService;
import com.entity.vo.YonghuVO;
import com.entity.view.YonghuView;

@Service("yonghuService")
public class YonghuServiceImpl extends ServiceImpl<YonghuDao, YonghuEntity> implements YonghuService {

	@Autowired
	private EpidemicService epidemicService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YonghuEntity> page = this.selectPage(
                new Query<YonghuEntity>(params).getPage(),
                new EntityWrapper<YonghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YonghuEntity> wrapper) {
		  Page<YonghuView> page =new Query<YonghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YonghuVO> selectListVO(Wrapper<YonghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

    @Override
    public List<YonghuVO> selectAll() {
		return baseMapper.selectAll();
    }

    @Override
	public YonghuVO selectVO(Wrapper<YonghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YonghuView> selectListView(Wrapper<YonghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YonghuView selectView(Wrapper<YonghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


	/**
	 * 更新
	 * @param yonghu
	 */
	@Override
	public void updateYonghu(YonghuEntity yonghu) {
		// 判断用户的状态有没有更改，这里存储用户状态更改的时间
		if(yonghu.getStatus() != null && yonghu.getStatus() == 1){
			// 如果修改状态为确诊 1 向日志中添加记录，还需要判断是否隔离
			if(yonghu.getBack_status() != null && yonghu.getBack_status() == 0){
				// 说明只是确诊为隔离，直接添加记录
				EpidemicLog epidemicLog = new EpidemicLog();
				epidemicLog.setQzTime(new Date());
				epidemicLog.setUserId(yonghu.getId());
				epidemicService.insert(epidemicLog);
			}else if (yonghu.getBack_status() != null && yonghu.getBack_status() == 1){
				// 说明是确诊并且隔离，修改日志记录
				EpidemicLog epidemicLog = epidemicService.getById(yonghu.getId());
				epidemicLog.setGlTime(new Date()); // 隔离时间
				epidemicService.updateById(epidemicLog);
			}else if (yonghu.getBack_status() != null && yonghu.getBack_status() == 2){
				// 治愈后解除隔离，并且把状态修改为0 正常
				EpidemicLog epidemicLog = epidemicService.getById(yonghu.getId());
				epidemicLog.setZyTime(new Date()); // 治愈时间
				epidemicService.updateById(epidemicLog);
				// 修改用户状态status --> 0
				yonghu.setStatus(0);
				updateById(yonghu);
			}
		}else if (yonghu.getStatus() != null && yonghu.getStatus() == 2){
			// 无症状感染者
			// 如果修改状态为确诊 1 向日志中添加记录，还需要判断是否隔离
			if(yonghu.getBack_status() != null && yonghu.getBack_status() == 0){
				// 说明只是确诊为隔离，直接添加记录
				EpidemicLog epidemicLog = new EpidemicLog();
				// epidemicLog.setQzTime(new Date());
				epidemicLog.setWzzTime(new Date());
				epidemicLog.setUserId(yonghu.getId());
				epidemicService.insert(epidemicLog);
			}else if (yonghu.getBack_status() != null && yonghu.getBack_status() == 1){
				// 说明是确诊并且隔离，修改日志记录
				EpidemicLog epidemicLog = epidemicService.getById(yonghu.getId());
				epidemicLog.setGlTime(new Date()); // 隔离时间
				epidemicService.updateById(epidemicLog);
			}else if (yonghu.getBack_status() != null && yonghu.getBack_status() == 2){
				// 治愈后解除隔离，并且把状态修改为0 正常
				EpidemicLog epidemicLog = epidemicService.getById(yonghu.getId());
				epidemicLog.setZyTime(new Date()); // 治愈时间
				epidemicService.updateById(epidemicLog);
				// 修改用户状态status --> 0
				yonghu.setStatus(0);
				updateById(yonghu);
			}
		}
		// 修改用户
		yonghu.setAddtime(new Date());
		updateById(yonghu);
	}
}
