package com.zks.app.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/"})
public class UI_Controller {
	/**
	 * index UI
	 * @return
	 */
	@RequestMapping(value="/index",method=GET)
	public String index(){
		return "index";
	}
}
