package com.zks.app.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.zks.app.enums.GenderType;

public class LoginForm {
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
	
	
}
