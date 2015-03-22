package com.zy.wechat.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zy.wechat.service.SystemInterface;
import com.zy.wechat.service.UserService;

@RestController
@RequestMapping("/cli")
public class Command {

	@Resource
	private SystemInterface systemInterface;
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/p", method = RequestMethod.GET)
	public String cli(String cmd, String param) {

		return systemInterface.exec(cmd, param);
	}
	
	@RequestMapping("/test")
	public String test(){
		userService.test();
		return "";
	}
}
