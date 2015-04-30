package com.wenchanter.web.sample.test.hessian;

import java.net.MalformedURLException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.wenchanter.web.sample.hessian.HessianServerSample;
import com.wenchanter.web.sample.pojo.SamplePojo;

public class HessianTest {
	private static HessianServerSample hessianServerSample;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setChunkedPost(false);
		factory.setOverloadEnabled(true);
	    try {
	    	hessianServerSample  = (HessianServerSample) factory.create(HessianServerSample.class,
					"http://127.0.0.1:8080/service");
		} catch (MalformedURLException e) {
		}
	}
	
	@Test
	public void testHessian() {
		System.out.println(hessianServerSample.hessianTest());
	}
	
	@Test
	public void testHessianPojo() {
		SamplePojo pojo = new SamplePojo();
		pojo.setContent("content");
		pojo.setId(10);
		Date d = new Date();
		System.out.println(d);
		pojo.setTime(d);
		pojo.setUserid("wang_hui");
		
		System.out.println(hessianServerSample.pojoTest(pojo));
	}
}
