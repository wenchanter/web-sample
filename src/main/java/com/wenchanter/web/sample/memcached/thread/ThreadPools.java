package com.wenchanter.web.sample.memcached.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池示例类.
 * @author liub
 *
 */
public class ThreadPools {

	//memcache数据线程池.
	public static final ExecutorService memcacheUpdateExec = new ThreadPoolExecutor(0, 25, 10 * 60L, TimeUnit.SECONDS,
			new SynchronousQueue<Runnable>());

}
