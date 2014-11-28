package com.wenchanter.web.sample.util;

public class ConstantsUtils {

	public static final int THREE_DAY_EXPIRE = 3600 * 24 * 3;
	
	public static String getSampleMemKey(int sampleid) {
		return "sam-" + sampleid;
	}
}
