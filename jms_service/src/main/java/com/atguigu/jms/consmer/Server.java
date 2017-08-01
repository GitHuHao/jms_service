package com.atguigu.jms.consmer;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {

	private static final Logger LOG = Logger.getLogger(Server.class);
	
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext(new String[] { "server.xml" });
		LOG.info("Server started.");
	}
}