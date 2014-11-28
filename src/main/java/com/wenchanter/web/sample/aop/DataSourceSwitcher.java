package com.wenchanter.web.sample.aop;

public class DataSourceSwitcher {
	
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static void setDataSource(String dataSource) {
		contextHolder.set(dataSource);
	}

	public static void setMaster() {
		clearDataSource();
	}

	public static void setSlave() {
		setDataSource("slave");
	}

	public static String getDataSource() {
		return (String) contextHolder.get();
	}

	public static void clearDataSource() {
		contextHolder.remove();
	}
}