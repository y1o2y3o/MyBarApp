package com.zks.app.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zks.app.web.form.RegisterForm;
import com.zks.app.web.form.TestForm;

@Controller
@RequestMapping(value={"/Account"})
public class AccountController {

	/**
	 * register UI
	 * @return
	 */
	@RequestMapping(value="/register",method=GET)
	public String registerUI(){
		return "account/register";
	}
	/**
	 * register function
	 * @param mm
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(value="/register",method=POST)
	public String register(@Valid RegisterForm registerForm, BindingResult result){
		
		System.out.println(result.getErrorCount());
		for(ObjectError e: result.getAllErrors()){
			System.out.println(e.getDefaultMessage());
		}
		return "account/register";
	}
	
	
}
