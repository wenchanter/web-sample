package com.wenchanter.web.sample.test.jms;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenchanter.web.sample.jms.JmsSample;

public class JmsTest {

	private JmsSample jmsSample;
	
	@Before
	public void setUp() {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext-all.xml");
//		destination = (Destination)act.getBean("sendFeedDestination");
//		jmsTemplate = (JmsTemplate)act.getBean("socialJmsTemplate");
		jmsSample = (JmsSample)act.getBean("jmsSample");
	}
	
	@Test
	public void testSendJMS() {
		jmsSample.stat();
	}
	
	@Test
	public void testConsumeJMS() {
//		while(true) {
//			
//		}
	}
	

}

