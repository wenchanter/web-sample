package com.wenchanter.web.sample.test.memcache;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenchanter.web.sample.memcached.thread.ThreadManager;


public class MemcachedTest {

	XMemcachedClient xMemcachedClient;

	@Before
	public void setUp() throws Exception {
		BeanFactory factory = new ClassPathXmlApplicationContext(new String[] { "applicationContext-all.xml" });
		xMemcachedClient = (XMemcachedClient) factory.getBean("socialMemcachedCacheClient");
	}
	
	@Test
	public void testAddMemcached() throws TimeoutException, InterruptedException, MemcachedException {
		ThreadManager.startExecMemcacheUpdate(xMemcachedClient, "social test", 1000 * 60, "测试");
//		xMemcachedClient.set("social test", 1000, "再测");
		System.out.println(xMemcachedClient.get("social test"));
	}
	
	@Test
	public void testGetMemcached() throws TimeoutException, InterruptedException, MemcachedException {
		System.out.println(xMemcachedClient.get("social test"));
	}
}
