package com.wenchanter.web.sample.test.hessian;

import org.junit.BeforeClass;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.wenchanter.web.sample.hessian.HessianServerSample;

public class HessianTest {
	private static HessianServerSample hessianServerSample;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setChunkedPost(false);
		//factory.setOverloadEnabled(true);
//	    try {
//	    	hessianServerSample  = (HessianServerSample) factory.create(HessianServerSample.class,
//					"http://127.0.0.1:8080/service");
//		} catch (MalformedURLException e) {
//		}
	}
	
	@Test
	public void testHessian() {
//		System.out.println(hessianServerSample.hessianTest());
	}
}
