package com.quanfeng.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {
	

		public String hello() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("____");
		return "index";
	}

	@Override
	@RequestMapping(value = "hello", method = RequestMethod.GET)

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		 ModelAndView mv = new ModelAndView();      
	       //添加模型数据 可以是任意的POJO对象      
	       mv.addObject("message", "Hello World!");      
	       //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面      
	       mv.setViewName("hello");      
		System.out.println("____");
		return mv;
	}
}
