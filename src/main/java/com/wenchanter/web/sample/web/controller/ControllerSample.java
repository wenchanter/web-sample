package com.wenchanter.web.sample.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notify/controller")
public class ControllerSample {
	
	@RequestMapping("/test")
	@ResponseBody
	public static  Map<String, Object> controllerTest() {
		System.out.println("this is notify controller test!");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyString", "test key social!");
		map.put("keyNum", 4);
		return map;
	}
	
}
