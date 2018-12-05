package com.zks.app.web.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.zks.app.enums.GenderType;
import com.zks.app.enums.StateType;

public class RegisterForm implements Serializable{
	
	/*
	 * 账号为3-20位字母或数字下划线
	 */
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9_-]{3,20}$", message="账号不合法")
	protected String input_account;
	
	/*
	 * 密码为任意数字字母或特殊符号
	 */
	@NotNull
	@Pattern(regexp="[0-9a-zA-Z!@#$%^&*()_+]{1,16}", message="密码不合法")
	protected String input_password;
	
	/*
	 * 用户名为任意非空字符串
	 */
	@NotNull
	@NotBlank(message="用户名不能为空")
	protected String input_username;
	
	@NotNull
	protected GenderType input_gender;
	
	/*
	 * 国内合法手机号
	 */
	@NotNull
	@Pattern(regexp="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$", message="手机号不合法")
	protected String input_phonenum;
	
	protected Map<String, String> errors = new HashMap<String, String>();
	
	

	public String getInput_account() {
		return input_account;
	}

	public void setInput_account(String input_account) {
		this.input_account = input_account;
	}

	public String getInput_password() {
		return input_password;
	}

	public void setInput_password(String input_password) {
		this.input_password = input_password;
	}

	public String getInput_username() {
		return input_username;
	}

	public void setInput_username(String input_username) {
		this.input_username = input_username;
	}

	public GenderType getInput_gender() {
		return input_gender;
	}

	public void setInput_gender(GenderType input_gender) {
		this.input_gender = input_gender;
	}

	public String getInput_phonenum() {
		return input_phonenum;
	}

	public void setInput_phonenum(String input_phonenum) {
		this.input_phonenum = input_phonenum;
	}

	
	
}
