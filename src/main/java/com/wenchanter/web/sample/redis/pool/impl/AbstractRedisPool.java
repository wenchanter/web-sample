package com.wenchanter.web.sample.redis.pool.impl;

import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Sharded;

import com.wenchanter.web.sample.redis.pool.IRedisPool;


/**
 * @author wenchanter
 */
public abstract class AbstractRedisPool implements IRedisPool {

//	protected Log logger = LogFactory.getLog(this.getClass());

	protected void init() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(1000);
			config.setMaxIdle(100);
			config.setMaxWaitMillis(1000);
			//调整jedis连接池配置added by zhuran 2012-03-05
			config.setTestOnBorrow(true);
			//config.setMinIdle(10);
			//config.setMinEvictableIdleTimeMillis(60000);
			//config.setTimeBetweenEvictionRunsMillis(600000);
			Properties res = new Properties();
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("redis.properties");
			res.load(in);
			in.close();
			ArrayList<JedisShardInfo> userMasterWriteJedisShardInfoList = new ArrayList<JedisShardInfo>();
			for (int j = 1; j < 5; j++) {
				String masterAddress = res.getProperty(this.getMasterAddress(j));
				if (StringUtils.isBlank(masterAddress)) {
					break;
				}
				String[] masterWriteJedisPorts = res.getProperty(this.getMasterWriteJedis(j)).split(",");
				for (int i = 0; i < masterWriteJedisPorts.length; i++) {
					JedisShardInfo userMasterWriteJedis = new JedisShardInfo(InetAddress.getByName(masterAddress)
							.getHostAddress(), Integer.parseInt(masterWriteJedisPorts[i]), 10000, 1);
					userMasterWriteJedisShardInfoList.add(userMasterWriteJedis);
				}
			}
			ShardedJedisPool masterWriteShardedJedisPool = new ShardedJedisPool(config,
					userMasterWriteJedisShardInfoList, Sharded.DEFAULT_KEY_TAG_PATTERN);
			this.setMasterWriteShardedJedisPool(masterWriteShardedJedisPool);
			ShardedJedisPool masterReadShardedJedisPool = new ShardedJedisPool(config,
					userMasterWriteJedisShardInfoList, Sharded.DEFAULT_KEY_TAG_PATTERN);
			this.setMasterReadShardedJedisPool(masterReadShardedJedisPool);
			ArrayList<JedisShardInfo> userSlaveReadJedisShardInfoList = new ArrayList<JedisShardInfo>();
			for (int j = 1; j < 5; j++) {
				String slaveAddress = res.getProperty(this.getSlaveAddress(j));
				if (StringUtils.isBlank(slaveAddress)) {
					break;
				}
				String[] userSlaveReadJedisPorts = res.getProperty(this.getSlaveReadJedis(j)).split(",");
				for (int i = 0; i < userSlaveReadJedisPorts.length; i++) {
					JedisShardInfo userSlaveReadJedis = new JedisShardInfo(InetAddress.getByName(slaveAddress)
							.getHostAddress(), Integer.parseInt(userSlaveReadJedisPorts[i]), 10000, 1);
					userSlaveReadJedisShardInfoList.add(userSlaveReadJedis);
				}
			}
			ShardedJedisPool slaveReadShardedJedisPool = new ShardedJedisPool(config, userSlaveReadJedisShardInfoList,
					Sharded.DEFAULT_KEY_TAG_PATTERN);
			this.setSlaveReadShardedJedisPool(slaveReadShardedJedisPool);

//			ArrayList<JedisShardInfo> queueJedisShardInfoList = new ArrayList<JedisShardInfo>();
//			String queueAddress = res.getProperty(this.getQueueAddress());
//			String queuePort = res.getProperty(this.getQueueJedis());
//			JedisShardInfo queueJedis = new JedisShardInfo(InetAddress.getByName(queueAddress).getHostAddress(),
//					Integer.parseInt(queuePort), 2000, 1);
//			queueJedisShardInfoList.add(queueJedis);
//			ShardedJedisPool queueShardedJedisPool = new ShardedJedisPool(config, queueJedisShardInfoList,
//					Sharded.DEFAULT_KEY_TAG_PATTERN);
//			this.setQueueShardedJedisPool(queueShardedJedisPool);

		} catch (Exception e) {
//			logger.error("RedisPoolForNews pool init happen error:" + e);
			e.printStackTrace();
		}
	}

	protected abstract void setMasterWriteShardedJedisPool(ShardedJedisPool masterWriteShardedJedisPool);

	protected abstract void setMasterReadShardedJedisPool(ShardedJedisPool masterReadShardedJedisPool);

	protected abstract void setSlaveReadShardedJedisPool(ShardedJedisPool slaveReadShardedJedisPool);

	protected abstract void setQueueShardedJedisPool(ShardedJedisPool queueShardedJedisPool);

	protected abstract String getMasterAddress(int i);

	protected abstract String getSlaveAddress(int i);

	protected abstract String getMasterWriteJedis(int i);

	protected abstract String getSlaveReadJedis(int i);

	protected abstract String getQueueAddress();

	protected abstract String getQueueJedis();

}
