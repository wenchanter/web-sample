package com.wenchanter.web.sample.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsSample {

	@Resource(name= "sendFeedDestination")
	private Destination destination;
	@Resource(name="socialJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	public void stat() {
		// 统计iphone客户端下载软件量
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage message = session.createObjectMessage();
				message.setStringProperty("passport", "jms test passport");
				return message;
			}
		});
	}
}
