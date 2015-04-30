package com.wenchanter.web.sample.pojo;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * ������Ҫ�־û��Ķ�����Ҫ�̳�����ࡣ
 * 
 * @author Jeffrey.Deng
 * 
 */
public abstract class PersistentObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���ظ��������Ҫ�����ı�
	 * 
	 * @return
	 */
	public abstract String getTable();

	public abstract String getPartition();

	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	/**
	 * ���������Ҫ�������
	 */
	public String toString() {
		try {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
		}
		catch (Throwable e) {
			return getClass().getName();
		}
	}

}
