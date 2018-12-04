package com.zks.app.web.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.zks.app.enums.GenderType;
import com.zks.app.enums.StateType;

public class RegisterForm implements Serializable{
	/*
	 * 账号为英文+邮箱
	 */
	@Pattern(regexp="zks")
	@NotNull
	@NotBlank
	protected String input_account;
	
	
	protected String input_password;
	
	protected String input_username;
	
	protected GenderType input_gender = GenderType.MALE;
	
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
