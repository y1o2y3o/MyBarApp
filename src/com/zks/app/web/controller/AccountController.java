package com.zks.app.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.zks.app.domain.User;
import com.zks.app.service.AccountService;
import com.zks.app.util.ContextHelper;
import com.zks.app.util.ConvertionHelper;
import com.zks.app.web.form.LoginForm;
import com.zks.app.web.form.RegisterForm;
import com.zks.app.web.form.TestForm;

@Controller
@RequestMapping(value={"/Account"})
public class AccountController {
	private AccountService accountService = ContextHelper.getAccountService();
	
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
	public String register(@Valid RegisterForm registerForm, BindingResult result,
				HttpSession session, HttpServletRequest request){
		// 验证失败: 返回注册页面
		if(result.hasErrors()){
			request.setAttribute("registerForm", registerForm);
			return "account/register";
		}
		
		// 验证成功: 开启注册服务
		User user = new User();
		// registerForm表单数据导入User类
		ConvertionHelper.convertRegisterForm_User(registerForm, user);
		
		if(accountService.register(user)){ //注册成功: 重定向主页			
			return "redirect:/index";
		}
		else{ // 注册失败: 存在重复账户,返回注册页面
			request.setAttribute("registerForm", registerForm);
			return "account/register";
		}	
	}
	/**
	 * login UI
	 * @return
	 */
	@RequestMapping(value="/login",method=GET)
	public String loginUI(){
		return "account/login";
	}
	
	/**
	 * login function
	 * @param mm
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(value="/login",method=POST)
	public String login(@Valid LoginForm loginForm, BindingResult result,
				HttpSession session, HttpServletRequest request){
		// 验证失败: 返回登陆页面
		if(result.hasErrors()){
			request.setAttribute("loginForm", loginForm);
			return "account/login";
		}
		
		// 验证成功: 开启登陆服务
		User user = accountService.login(loginForm.getInput_account(), loginForm.getInput_password());
		
		if(user != null){// 登陆成功跳转主页
			session.setAttribute("user", user);
			return "redirect:/index";
		}
		else{ // 登陆失败: 账号密码不合法,返回登陆页面
			request.setAttribute("loginForm", loginForm);
			return "account/login";
		}	
	}
	
}
