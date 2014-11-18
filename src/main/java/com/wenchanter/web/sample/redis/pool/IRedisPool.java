package com.wenchanter.web.sample.redis.pool;

import redis.clients.jedis.ShardedJedis;

/**
 * @author wenchanter
 */
public interface IRedisPool {

	public ShardedJedis getWriteRedis();

	public void returnWriteRedis(ShardedJedis shardedJedis);

	public ShardedJedis getMasterReadRedis();

	public void returnMasterReadRedis(ShardedJedis shardedJedis);

	public ShardedJedis getSlaveReadRedis();

	public void returnSlaveReadRedis(ShardedJedis shardedJedis);

	public ShardedJedis getQueueRedis();

	public void returnQueueRedis(ShardedJedis shardedJedis);
}
