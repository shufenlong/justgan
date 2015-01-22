package com.springmvc.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quanfen.entity.User;
import com.quanfen.service.UserService;

@Controller
public class NewController {
	private UserService userService;
	@RequestMapping("/index")
	@ResponseBody
	public List<User> index(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		List<User> list = new ArrayList<User>();
		User user1 =new User("1111","1111",null);
		User user2 =new User("2222","222",null);
		list.add(user1);
		list.add(user2);
		return list;
	}

	@RequestMapping("/index2")
	@ResponseBody
	public User index2(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		List<User> list = new ArrayList<User>();
		User user1 =new User("1111","1111",null);
		User user2 =new User("2222","222",null);
		list.add(user1);
		list.add(user2);
		return user1;
	}
}
