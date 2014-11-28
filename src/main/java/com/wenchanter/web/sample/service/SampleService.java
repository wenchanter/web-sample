package com.wenchanter.web.sample.service;

import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wenchanter.web.sample.dao.SampleDao;
import com.wenchanter.web.sample.memcached.thread.ThreadManager;
import com.wenchanter.web.sample.pojo.SamplePojo;
import com.wenchanter.web.sample.util.ConstantsUtils;

@Service
public class SampleService {
	
	@Resource(name = "notifyMemcachedCacheClient")
	private XMemcachedClient xMemcachedClient;
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Resource
	private SampleDao sampleDao;
	
	public SamplePojo selectById(int id) {
		
		String memKey = ConstantsUtils.getSampleMemKey(id);
		
		SamplePojo sample = null;
		try {
			sample = (SamplePojo)xMemcachedClient.get(memKey);
			System.out.println("get from memcatch");
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			logger.error("get notify by id from memcatch err...", e);
		}
		if (sample != null) {
			return sample;
		}
		
		sample = sampleDao.selectById(id);
		System.out.println("get from db");
		if (sample != null) {
			ThreadManager.startExecMemcacheUpdate(xMemcachedClient, memKey, ConstantsUtils.THREE_DAY_EXPIRE, sample);
		}
		
		return sample;
	}
}
