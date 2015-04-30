package com.wenchanter.web.sample.hessian.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.wenchanter.web.sample.hessian.HessianServerSample;
import com.wenchanter.web.sample.pojo.SamplePojo;
import com.wenchanter.web.sample.pojo.ThreadData;

@Service("hessianServerSample")
public class HessianServerImpl implements HessianServerSample {

	@Override
	public Map<String, Object> hessianTest() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("key1", "hessian run!");
		map.put("key2", 2);
		
		return map;
	}

	@Override
	public SamplePojo pojoTest(SamplePojo pojo) {
		pojo.setContent(pojo.getContent() + " yigai");
		System.out.println(pojo.getContent() + " yigai");
		
		pojo.setId(pojo.getId() + 10);
		System.out.println(pojo.getId() + 10);
		System.out.println(pojo.getTime());
		pojo.setTime(new Date());
		pojo.setUserid(pojo.getUserid() + " yigai uid");
		System.out.println(pojo.getUserid() + " yigai uid");
		return pojo;
	}
	
	public ThreadData errPojoTest(String channel, String board, boolean needCheck, ThreadData data) {
		System.out.println(channel);
		System.out.println(board);
		System.out.println(needCheck);
		System.out.println(data.getTitle());
		return data;
	}
}
