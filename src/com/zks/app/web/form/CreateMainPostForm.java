package com.zks.app.web.form;

import java.util.HashSet;
import java.util.Set;


import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.zks.app.domain.Bar;
import com.zks.app.domain.Image;
import com.zks.app.domain.User;
import com.zks.app.domain.VisibilityType;

public class CreateMainPostForm {

	@NotNull
	protected String input_description;
	
	@NotNull
	protected String input_title;
	
	@NotNull
	protected Long input_user_id;
	
	@NotNull
	protected Long input_bar_id;

	public String getInput_description() {
		return input_description;
	}

	public void setInput_description(String input_description) {
		this.input_description = input_description;
	}

	public String getInput_title() {
		return input_title;
	}

	public void setInput_title(String input_title) {
		this.input_title = input_title;
	}

	public Long getInput_bar_id() {
		return input_bar_id;
	}

	public void setInput_bar_id(Long input_bar_id) {
		this.input_bar_id = input_bar_id;
	}
	
	public Long getInput_user_id() {
		return input_user_id;
	}

	public void setInput_user_id(Long input_user_id) {
		this.input_user_id = input_user_id;
	}
	
}
