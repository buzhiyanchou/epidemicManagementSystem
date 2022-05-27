package com.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.entity.view.YonghuView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.EpidemicDao;
import com.entity.ConfigEntity;
import com.entity.EpidemicLog;
import com.entity.YonghuEntity;
import com.entity.vo.EpidemicLogVo;
import com.service.ConfigService;
import com.service.EpidemicService;
import com.utils.JQPageInfo;
import com.utils.PageUtils;
import com.utils.Query;
import com.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("epidemicService")
@Slf4j
public class EpidemicServiceImpl extends ServiceImpl<EpidemicDao, EpidemicLog> implements EpidemicService {

    @Autowired
    private EpidemicDao epidemicDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ConfigEntity> wrapper) {
        Page<EpidemicLog> page = this.selectPage(
                new Query<EpidemicLog>(params).getPage(),
                new EntityWrapper<EpidemicLog>()
        );
        return new PageUtils(page);
    }

    @Override
    public Integer selectCountInDay() {
        return  epidemicDao.selectCountInDay();
    }

    /**
     * 根据用户ID查询日志记录
     * @param id
     * @return
     */
    @Override
    public EpidemicLog getById(Long id) {
       // EpidemicLog epidemicLog = epidemicDao.selectById(id+"");
        EpidemicLog epidemicLog = epidemicDao.queryById(id);
        return epidemicLog;
    }

    @Override
    public List<EpidemicLogVo> queryPage(Integer page,Integer size) {
        // TODO: 2022/5/24 获取返回疫情记录表的数据
        // 并能实现条件查询     需要将用户表中的 名字以及 status 连表查询返回
        if(page == null || size== null){
            throw new RuntimeException("参数不能为空");
        }
        PageHelper.startPage(page,size);

        List<EpidemicLogVo> list = epidemicDao.queryPage(page,size);
        log.info("查询到的元素 {}",list.get(0));
        PageInfo<EpidemicLogVo> logVoPageInfo = new PageInfo<>(list);
        List<EpidemicLogVo> voList = logVoPageInfo.getList();



        return voList;
    }

    @Override
    public List<EpidemicLog> selectListView(Wrapper<EpidemicLog> wrapper) {
        return baseMapper.selectListView(wrapper);
    }
}
