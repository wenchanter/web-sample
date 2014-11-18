package com.wenchanter.web.sample.redis.pool.impl;

import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author wenchanter
 */
@Repository("redisPool")
public class RedisPool extends AbstractRedisPool {

	private static ShardedJedisPool masterWriteShardedJedisPool = null;

	private static ShardedJedisPool masterReadShardedJedisPool = null;

	private static ShardedJedisPool slaveReadShardedJedisPool = null;

	private static ShardedJedisPool masterQueueShardedJedisPool = null;

//	private static RedisPool instance = new RedisPool();

	private RedisPool() {
		init();
	}

//	public static RedisPool getInstance() {
//		return instance;
//	}

	@Override
	protected String getMasterAddress(int i) {
		return "redis" + i + ".master.address";
	}

	@Override
	protected String getMasterWriteJedis(int i) {
		return "redis" + i + ".master.port";
	}

	@Override
	protected String getSlaveAddress(int i) {
		return "redis" + i + ".slave.address";
	}

	@Override
	protected String getSlaveReadJedis(int i) {
		return "redis" + i + ".slave.port";
	}

	@Override
	protected String getQueueAddress() {
		return "redis.queue.address";
	}

	@Override
	protected String getQueueJedis() {
		return "redis.queue.port";
	}

	@Override
	public ShardedJedis getMasterReadRedis() {
		return masterReadShardedJedisPool.getResource();
	}

	@Override
	public ShardedJedis getSlaveReadRedis() {
		return slaveReadShardedJedisPool.getResource();
	}

	@Override
	public ShardedJedis getWriteRedis() {
		return masterWriteShardedJedisPool.getResource();
	}

	@Override
	public ShardedJedis getQueueRedis() {
		return masterQueueShardedJedisPool.getResource();
	}

	@Override
	public void returnMasterReadRedis(ShardedJedis shardedJedis) {
		masterReadShardedJedisPool.returnResource(shardedJedis);
	}

	@Override
	public void returnSlaveReadRedis(ShardedJedis shardedJedis) {
		slaveReadShardedJedisPool.returnResource(shardedJedis);
	}

	@Override
	public void returnWriteRedis(ShardedJedis shardedJedis) {
		masterWriteShardedJedisPool.returnResource(shardedJedis);
	}

	@Override
	public void returnQueueRedis(ShardedJedis shardedJedis) {
		masterQueueShardedJedisPool.returnResource(shardedJedis);
	}

	@Override
	protected void setMasterReadShardedJedisPool(ShardedJedisPool masterReadShardedJedisPool) {
		RedisPool.masterReadShardedJedisPool = masterReadShardedJedisPool;
	}

	@Override
	protected void setMasterWriteShardedJedisPool(ShardedJedisPool masterWriteShardedJedisPool) {
		RedisPool.masterWriteShardedJedisPool = masterWriteShardedJedisPool;
	}

	@Override
	protected void setSlaveReadShardedJedisPool(ShardedJedisPool slaveReadShardedJedisPool) {
		RedisPool.slaveReadShardedJedisPool = slaveReadShardedJedisPool;
	}

	@Override
	protected void setQueueShardedJedisPool(ShardedJedisPool queueShardedJedisPool) {
		RedisPool.masterQueueShardedJedisPool = queueShardedJedisPool;
	}

}
