package com.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * 用户
 */
@Data
@TableName("users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 用户账号
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户类型
	 */
	private String role;

	private Date addtime;

//	手机号
	private String phone;

	private String code;
}
