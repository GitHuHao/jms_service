package com.atguigu.jms.broker;

import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Broker {
	
	private static final Logger LOG = Logger.getLogger(Broker.class);
	private static final String CONNECTOR_ADDRESS = "tcp://127.0.0.1:61616";
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "broker.xml" });
		BrokerService broker = (BrokerService) ctx.getBean("broker");
		try {
			broker.setBrokerName("myBroker");
			broker.setUseJmx(true);
			broker.addConnector(CONNECTOR_ADDRESS);
			broker.start();
			LOG.info("Broker service started.");
			
			Object lock = new Object();
			synchronized (lock) {
				lock.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}