package com.zks.app.util;

import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.User;
import com.zks.app.web.form.CreateBarForm;
import com.zks.app.web.form.CreateMainPostForm;
import com.zks.app.web.form.RegisterForm;

public class ConvertionHelper {
	public static void convertRegisterForm_User(RegisterForm registerForm, User user){
		user.setAccount(registerForm.getInput_account());
		user.setPassword(registerForm.getInput_password());
		user.setUsername(registerForm.getInput_username());
		user.setGender(registerForm.getInput_gender());
		user.setPhonenum(registerForm.getInput_phonenum());
	}
	
	public static void convertCreateBarForm_Bar(CreateBarForm createBarForm, Bar bar){
		bar.setName(createBarForm.getInput_name());
	}
	
}
