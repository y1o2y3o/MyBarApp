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

public class CreateSecondaryReplyPostForm {

	@NotNull @NotBlank
	protected String input_description;
	
	@NotNull
	protected Long input_hostreply_id;
	
	@NotNull
	protected Long input_user_id;

	@NotNull
	protected Long input_target_user_id;
	
	@NotNull
	protected Long input_mainpost_id;

	public String getInput_description() {
		return input_description;
	}

	public void setInput_description(String input_description) {
		this.input_description = input_description;
	}

	public Long getInput_hostreply_id() {
		return input_hostreply_id;
	}

	public void setInput_hostreply_id(Long input_hostreply_id) {
		this.input_hostreply_id = input_hostreply_id;
	}

	public Long getInput_user_id() {
		return input_user_id;
	}

	public void setInput_user_id(Long input_user_id) {
		this.input_user_id = input_user_id;
	}

	public Long getInput_target_user_id() {
		return input_target_user_id;
	}

	public void setInput_target_user_id(Long input_target_user_id) {
		this.input_target_user_id = input_target_user_id;
	}

	public Long getInput_mainpost_id() {
		return input_mainpost_id;
	}

	public void setInput_mainpost_id(Long input_mainpost_id) {
		this.input_mainpost_id = input_mainpost_id;
	}
	
}
