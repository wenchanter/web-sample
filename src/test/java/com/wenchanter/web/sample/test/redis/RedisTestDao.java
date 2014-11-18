package com.wenchanter.web.sample.test.redis;

import java.util.Random;

import javax.annotation.Resource;

import net.rubyeye.xmemcached.XMemcachedClient;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;

import com.wenchanter.web.sample.redis.pool.IRedisPool;
import com.wenchanter.web.sample.redis.pool.impl.RedisPool;

public class RedisTestDao {

	@Resource
	IRedisPool redisPool;
	
	@Before
	public void setUp() {
		BeanFactory factory = new ClassPathXmlApplicationContext(new String[] { "applicationContext-all.xml" });
		redisPool = (IRedisPool) factory.getBean("redisPool");
//		redisPool = RedisPool.getInstance();
	}
	
	@Test
	public void testSet() {

		ShardedJedis jedis = redisPool.getWriteRedis();

		String key = "social-redis-test";

		try {
			jedis.set(key, "redis测试");
		} finally {
			redisPool.returnWriteRedis(jedis);
		}

	}
	
	@Test
	public void testGet() {

		String key = "social-redis-test";

		boolean isMaster = new Random().nextBoolean();
		ShardedJedis jedis = null;
		if (isMaster) {
			jedis = redisPool.getMasterReadRedis();
		} else {
			jedis = redisPool.getSlaveReadRedis();
		}

		try {
			System.out.println(jedis.get(key));
		} finally {
			if (isMaster) {
				redisPool.returnMasterReadRedis(jedis);
			} else {
				redisPool.returnSlaveReadRedis(jedis);
			}
		}
	}
}
