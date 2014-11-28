package com.wenchanter.web.sample.aop;

import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {  
	  
    @Override  
    protected Object determineCurrentLookupKey() {  
        return DataSourceSwitcher.getDataSource();  
    }

	@Override
	public Logger getParentLogger() {
		return null;
	}
  
}  