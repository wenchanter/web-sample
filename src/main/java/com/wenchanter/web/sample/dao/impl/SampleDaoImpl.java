package com.wenchanter.web.sample.dao.impl;

import org.springframework.stereotype.Repository;

import com.wenchanter.web.sample.dao.SampleDao;
import com.wenchanter.web.sample.pojo.SamplePojo;

@Repository
public class SampleDaoImpl extends BaseDao implements SampleDao {

	@Override
	public SamplePojo selectById(int id) {
		return (SamplePojo)this.queryForObject("selectById", id);
	}

}
