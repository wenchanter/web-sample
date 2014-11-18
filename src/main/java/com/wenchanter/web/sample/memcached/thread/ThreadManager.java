package com.wenchanter.web.sample.memcached.thread;

import net.rubyeye.xmemcached.XMemcachedClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 线程管理器.
 * @author liub
 *
 */

public class ThreadManager {

	private static Log logger = LogFactory.getLog(ThreadManager.class);

	public static final void startExecMemcacheUpdate(final XMemcachedClient memcachedClient, final String key,
			final int expire, final Object valve) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					memcachedClient.set(key, expire, valve);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		};
		logger.debug("update memcache: key=" + key + ", value=" + valve + ", expire=" + expire);
		ThreadPools.memcacheUpdateExec.execute(runnable);
	}

	public static final void startExecMemcacheDelete(final XMemcachedClient memcachedClient, final String key) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					memcachedClient.delete(key);
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e);
				}
			}
		};
		logger.debug("delete memcache: key=" + key);
		ThreadPools.memcacheUpdateExec.execute(runnable);
	}
}
