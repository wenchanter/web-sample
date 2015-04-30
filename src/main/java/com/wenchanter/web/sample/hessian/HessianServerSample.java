package com.wenchanter.web.sample.hessian;

import java.util.Map;

import com.wenchanter.web.sample.pojo.SamplePojo;
import com.wenchanter.web.sample.pojo.ThreadData;

public interface HessianServerSample {

	public Map<String, Object> hessianTest();
	
	public SamplePojo pojoTest(SamplePojo pojo);
	
	public ThreadData errPojoTest(String channel, String board, boolean needCheck, ThreadData data);
}
