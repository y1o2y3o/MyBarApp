package com.zks.app.web.controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zks.app.domain.Bar;
import com.zks.app.service.AccountService;
import com.zks.app.service.BarService;
import com.zks.app.util.ContextHelper;
import com.zks.app.util.ConvertionHelper;
import com.zks.app.web.form.CreateBarForm;

@Controller
@RequestMapping(value={"/Bar"})
public class BarController {
	private BarService barService = ContextHelper.getBarService();
	
	// 创建贴吧UI页面
	@RequestMapping(value="/create", method=GET)
	public String createUI(){
		return "bar/create";
	}
	
	// 创建贴吧
	@RequestMapping(value="/create", method=POST)
	public String create(@Valid CreateBarForm createBarForm, BindingResult result,
				HttpSession session, HttpServletRequest request){
		// 验证输入的贴吧名
		if(result.hasErrors()){ // 贴吧名字不合法
			request.setAttribute("createBarForm", createBarForm);
			return "bar/create";
		}
		
		// 验证成功
		Bar bar = new Bar();
		ConvertionHelper.convertCreateBarForm_Bar(createBarForm, bar);
		
		if(barService.create(bar)){
			//创建成功: 跳转成功页面
			return "bar/create_success";
		}
		
		// 创建失败: 贴吧已存在,返回创建页面
		request.setAttribute("createBarForm", createBarForm);
		return "bar/create";
	}
	
	// 显示所有贴吧
	@RequestMapping(value="/list", method=GET)
	public String list(
			HttpSession session, HttpServletRequest request){
			
		List<Bar> barList = barService.list();
		request.setAttribute("barList", barList);
		return "bar/list";
	}
}
