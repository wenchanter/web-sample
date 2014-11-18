package com.wenchanter.web.sample.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

public class JmsListenerSample implements MessageListener{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void onMessage(Message message) {
		try {
			String passport = message.getStringProperty("passport");
			System.out.println("jms listener test: " + passport);
			logger.info("JMSListenerTest:  end...");
		} catch (Exception e) {
			logger.error("JMSListenerTest error:", e);
		}
	}
}
