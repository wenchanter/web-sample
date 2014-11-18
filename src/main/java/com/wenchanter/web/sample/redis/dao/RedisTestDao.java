package com.wenchanter.web.sample.redis.dao;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;

import com.wenchanter.web.sample.redis.pool.IRedisPool;

@Repository
public class RedisTestDao {

	@Resource
	IRedisPool redisPool;
	
	public void testSet(String str) {

		ShardedJedis jedis = redisPool.getWriteRedis();

		String key = "social-redis-test";

		try {
			jedis.set(key, "redis测试");
		} finally {
			redisPool.returnWriteRedis(jedis);
		}

	}
	
	public String testGet() {

		String key = "social-redis-test";

		boolean isMaster = new Random().nextBoolean();
		ShardedJedis jedis = null;
		if (isMaster) {
			jedis = redisPool.getMasterReadRedis();
		} else {
			jedis = redisPool.getSlaveReadRedis();
		}

		try {
			return jedis.get(key);
		} finally {
			if (isMaster) {
				redisPool.returnMasterReadRedis(jedis);
			} else {
				redisPool.returnSlaveReadRedis(jedis);
			}
		}
	}
	
	public static void main(String[] arg) {
		BeanFactory factory = new ClassPathXmlApplicationContext(new String[] { "applicationContext-all.xml" });
		RedisTestDao dao = (RedisTestDao)factory.getBean("redisTestDao");
		System.out.println(dao.testGet());
	}
}
