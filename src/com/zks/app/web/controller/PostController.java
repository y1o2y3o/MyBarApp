package com.zks.app.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zks.app.domain.MainPost;
import com.zks.app.domain.Post;
import com.zks.app.service.PostService;
import com.zks.app.util.ContextHelper;

@Controller
@RequestMapping(value={"/Post"})
public class PostController {
	private PostService postService = ContextHelper.getPostService();
	/**
	 * 返回指定贴吧的帖子
	 * @param bar_id
	 * @return
	 */
	@RequestMapping(value="/list", method=GET)
	public String list(@RequestParam(value="bar_id", required=true)Long bar_id,
				HttpServletRequest request){
		postService.viewBarById(bar_id, request);
		return "post/list";
	}
}
