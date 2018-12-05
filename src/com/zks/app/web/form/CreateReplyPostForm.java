package com.zks.app.web.form;

import java.util.HashSet;
import java.util.Set;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.zks.app.domain.Bar;
import com.zks.app.domain.Image;
import com.zks.app.domain.User;
import com.zks.app.domain.VisibilityType;

public class CreateReplyPostForm {

	@NotNull @NotBlank
	protected String input_description;
	
	@NotNull
	protected Long input_hostpost_id;
	
	@NotNull
	protected Long input_user_id;

	public String getInput_description() {
		return input_description;
	}

	public void setInput_description(String input_description) {
		this.input_description = input_description;
	}

	public Long getInput_hostpost_id() {
		return input_hostpost_id;
	}

	public void setInput_hostpost_id(Long input_hostpost_id) {
		this.input_hostpost_id = input_hostpost_id;
	}

	public Long getInput_user_id() {
		return input_user_id;
	}

	public void setInput_user_id(Long input_user_id) {
		this.input_user_id = input_user_id;
	}
	
	
	
}
