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
 * 出入信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-10 14:25:06
 */
@TableName("churuxinxi")
public class ChuruxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChuruxinxiEntity() {
		
	}
	
	public ChuruxinxiEntity(T t) {
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
	 * 出入类型
	 */
					
	private String churuleixing;
	
	/**
	 * 出入标题
	 */
					
	private String churubiaoti;
	
	/**
	 * 出入图片
	 */
					
	private String churutupian;
	
	/**
	 * 出入次数
	 */
					
	private Integer churucishu;
	
	/**
	 * 行程上报
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date xingchengshangbao;
	
	/**
	 * 出入说明
	 */
					
	private String churushuoming;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
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
	 * 设置：出入类型
	 */
	public void setChuruleixing(String churuleixing) {
		this.churuleixing = churuleixing;
	}
	/**
	 * 获取：出入类型
	 */
	public String getChuruleixing() {
		return churuleixing;
	}
	/**
	 * 设置：出入标题
	 */
	public void setChurubiaoti(String churubiaoti) {
		this.churubiaoti = churubiaoti;
	}
	/**
	 * 获取：出入标题
	 */
	public String getChurubiaoti() {
		return churubiaoti;
	}
	/**
	 * 设置：出入图片
	 */
	public void setChurutupian(String churutupian) {
		this.churutupian = churutupian;
	}
	/**
	 * 获取：出入图片
	 */
	public String getChurutupian() {
		return churutupian;
	}
	/**
	 * 设置：出入次数
	 */
	public void setChurucishu(Integer churucishu) {
		this.churucishu = churucishu;
	}
	/**
	 * 获取：出入次数
	 */
	public Integer getChurucishu() {
		return churucishu;
	}
	/**
	 * 设置：行程上报
	 */
	public void setXingchengshangbao(Date xingchengshangbao) {
		this.xingchengshangbao = xingchengshangbao;
	}
	/**
	 * 获取：行程上报
	 */
	public Date getXingchengshangbao() {
		return xingchengshangbao;
	}
	/**
	 * 设置：出入说明
	 */
	public void setChurushuoming(String churushuoming) {
		this.churushuoming = churushuoming;
	}
	/**
	 * 获取：出入说明
	 */
	public String getChurushuoming() {
		return churushuoming;
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
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
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
