package com.wenchanter.web.sample.hessian.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wenchanter.web.sample.hessian.HessianServerSample;

@Service("HessianServerSample")
public class HessianServerImpl implements HessianServerSample {

	@Override
	public Map<String, Object> hessianTest() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("key1", "hessian run!");
		map.put("key2", 2);
		
		return map;
	}

}
