package com.zks.app.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zks.app.domain.Bar;
import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.service.BarService;
import com.zks.app.service.PostService;
import com.zks.app.util.ContextHelper;
import com.zks.app.util.PostPager;
import com.zks.app.util.Pager;
import com.zks.app.web.form.CreateMainPostForm;
import com.zks.app.web.form.CreateReplyPostForm;
import com.zks.app.web.form.CreateSecondaryReplyPostForm;

@Controller
@RequestMapping(value={"/Post"})
public class PostController {
	private PostService postService = ContextHelper.getPostService();
	private BarService barService = ContextHelper.getBarService();
	
	// list指定贴吧的主题帖: 分页
	@RequestMapping(value="/list", method=GET)
	public String list(@RequestParam(value="bar_id", required=true)Long bar_id,
			@RequestParam(value="page", required=true)Integer page,
			@RequestParam(value="size", required=true)Integer size,
			@RequestParam(value="orderby", required=true)String orderby,
			HttpServletRequest request){
		// 验证参数 合法性
		if (bar_id == null || page == null || size== null|| orderby==null)
			return "error"; //不是合法的
		
		// 从数据库get主题帖记录
		PostPager<MainPost>pager = postService.listMain(page, size, bar_id, orderby);
		request.setAttribute("pager", pager);
		return "post/list";
	}
	
	
	// 创建主题帖UI
	@RequestMapping(value="/create_main", method=GET)
	public String createMainPostUI(@RequestParam(value="bar_id", required=true) Long bar_id,
				HttpServletRequest request){
		request.setAttribute("bar_id", bar_id);
		return "post/create_main";
	}
	
	// 创建主题帖
	@RequestMapping(value="/create_main", method=POST)
	public String createMainPost(@Valid CreateMainPostForm createMainPostForm, BindingResult result,
			HttpSession session, HttpServletRequest request){
		if(result.hasErrors()){
			request.setAttribute("createMainPostForm", createMainPostForm);
			return "post/create_main";
		}
		// 创建主题帖成功: 重定向至贴吧
		if(postService.crateMainPost(createMainPostForm))
			return "redirect:/Post/list?page=0&size=20&orderby=lastReplyOn&bar_id="+createMainPostForm.getInput_bar_id();
		
		// 创建失败: 遇到未知错误
		return "error";
	}
	
	// 主题帖显示页面
	@RequestMapping(value="/main", method=GET)
	public String viewMainPost(@RequestParam(value="mainpost_id") Long mainpost_id, HttpServletRequest request){
		if(postService.viewMainPostById(mainpost_id, request))
			return "post/main";
		
		// 显示错误: 未知问题
		return "error";
	}
	// 主题帖显示页面
	@RequestMapping(value="/main", method=GET)
	public String listReply(@RequestParam(value="main_id", required=true) Long main_id,
			@RequestParam(value="post_starter_id", required=true) Long post_starter_id,
			@RequestParam(value="reply_author_id", required=true) Long reply_author_id,
			@RequestParam(value="sc", required=true) String sc,
			@RequestParam(value="page", required=true)Integer page,
			@RequestParam(value="size", required=true)Integer size,
			HttpServletRequest request){
		// 参数不合法
		if(main_id==null||post_starter_id==null||reply_author_id==null||sc==null
				||page==null||size==null)
			return "error";
		PostPager pager = postService.listReply()
			
		request.setAttribute("pager", pager);
		}
	// 创建回复帖
	@RequestMapping(value="/create_reply", method=POST)
	public String createReply(@Valid CreateReplyPostForm form, BindingResult result,
				HttpServletRequest request){
		if(result.hasErrors()){
			request.setAttribute("form", form);
			return "post/create_reply";
		}
		if(postService.createReply(form))
			return "redirect:/Post/main?mainpost_id="+form.getInput_hostpost_id();
			
		// 显示错误: 未知问题
		return "error";
	}
	
	// 创建楼中楼回复帖
	@RequestMapping(value="/create_secondary_reply", method=POST)
	public String createSecondaryReply(@Valid CreateSecondaryReplyPostForm form, BindingResult result,
			HttpServletRequest request){
		if(result.hasErrors()){
			request.setAttribute("form", form);
			return "post/create_reply";
		}
		if(postService.createSecondaryReply(form))
			return "redirect:/Post/main?mainpost_id="+form.getInput_mainpost_id();
		
		// 显示错误: 未知问题
		return "error";
	}
}
