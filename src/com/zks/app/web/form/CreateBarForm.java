package com.zks.app.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class CreateBarForm {
	/*
	 * 账号为3-20位字母或数字下划线
	 */
	@NotNull @NotBlank(message="贴吧名不合法")
	protected String input_name;

	public String getInput_name() {
		return input_name;
	}

	public void setInput_name(String input_name) {
		this.input_name = input_name;
	}
	
	
}
