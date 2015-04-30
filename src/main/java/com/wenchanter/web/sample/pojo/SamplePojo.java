package com.wenchanter.web.sample.pojo;

import java.io.Serializable;
import java.util.Date;

public class SamplePojo implements Serializable{

	private static final long serialVersionUID = -3683651535449994159L;

	private int id;
	
	private String content;
	
	private String userid;
	
	private Date time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
