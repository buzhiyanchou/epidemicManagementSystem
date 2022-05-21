package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健康信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-10 14:25:06
 */
@TableName("jiankangxinxi")
public class JiankangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangxinxiEntity() {
		
	}
	
	public JiankangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 上报标题
	 */
					
	private String shangbaobiaoti;
	
	/**
	 * 上报图片
	 */
					
	private String shangbaotupian;
	
	/**
	 * 个人体温
	 */
					
	private String gerentiwen;
	
	/**
	 * 身体状况
	 */
					
	private String shentizhuangkuang;
	
	/**
	 * 风险地区
	 */
					
	private String fengxiandiqu;
	
	/**
	 * 上报内容
	 */
					
	private String shangbaoneirong;
	
	/**
	 * 上报日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date shangbaoriqi;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 住址
	 */
					
	private String zhuzhi;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 审核回复
	 */
					
	private String shhf;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：上报标题
	 */
	public void setShangbaobiaoti(String shangbaobiaoti) {
		this.shangbaobiaoti = shangbaobiaoti;
	}
	/**
	 * 获取：上报标题
	 */
	public String getShangbaobiaoti() {
		return shangbaobiaoti;
	}
	/**
	 * 设置：上报图片
	 */
	public void setShangbaotupian(String shangbaotupian) {
		this.shangbaotupian = shangbaotupian;
	}
	/**
	 * 获取：上报图片
	 */
	public String getShangbaotupian() {
		return shangbaotupian;
	}
	/**
	 * 设置：个人体温
	 */
	public void setGerentiwen(String gerentiwen) {
		this.gerentiwen = gerentiwen;
	}
	/**
	 * 获取：个人体温
	 */
	public String getGerentiwen() {
		return gerentiwen;
	}
	/**
	 * 设置：身体状况
	 */
	public void setShentizhuangkuang(String shentizhuangkuang) {
		this.shentizhuangkuang = shentizhuangkuang;
	}
	/**
	 * 获取：身体状况
	 */
	public String getShentizhuangkuang() {
		return shentizhuangkuang;
	}
	/**
	 * 设置：风险地区
	 */
	public void setFengxiandiqu(String fengxiandiqu) {
		this.fengxiandiqu = fengxiandiqu;
	}
	/**
	 * 获取：风险地区
	 */
	public String getFengxiandiqu() {
		return fengxiandiqu;
	}
	/**
	 * 设置：上报内容
	 */
	public void setShangbaoneirong(String shangbaoneirong) {
		this.shangbaoneirong = shangbaoneirong;
	}
	/**
	 * 获取：上报内容
	 */
	public String getShangbaoneirong() {
		return shangbaoneirong;
	}
	/**
	 * 设置：上报日期
	 */
	public void setShangbaoriqi(Date shangbaoriqi) {
		this.shangbaoriqi = shangbaoriqi;
	}
	/**
	 * 获取：上报日期
	 */
	public Date getShangbaoriqi() {
		return shangbaoriqi;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：住址
	 */
	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}
	/**
	 * 获取：住址
	 */
	public String getZhuzhi() {
		return zhuzhi;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：审核回复
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
