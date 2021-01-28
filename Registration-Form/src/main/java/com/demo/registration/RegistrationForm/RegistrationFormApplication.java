package com.demo.registration.RegistrationForm;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.logging.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author khushii spring boot execution class
 *
 */
@SpringBootApplication
@EnableTransactionManagement
public class RegistrationFormApplication {

	static Logger logger = LogManager.getLogger(RegistrationFormApplication.class);

	public static void main(String[] args) {
//		customLog();
		SpringApplication.run(RegistrationFormApplication.class, args);
	}

	public static void customLog() {
		//ServletWebServerInitializedEvent embeddedServletContainerInitializedEvent;
		// int port =
		// embeddedServletContainerInitializedEvent.getApplicationContext().getWebServer().getPort();
//		logger.info(port);
//		System.out.println(
//				"Port " + embeddedServletContainerInitializedEvent.getApplicationContext().getWebServer().getPort());
		try {
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			logger.info(hostAddress);
			System.out.println(hostAddress);
			MDC.put("hostAddress", hostAddress);
			System.out.println("HOST Address " + InetAddress.getLocalHost().getHostAddress());
			String hostName = InetAddress.getLocalHost().getHostName();
			logger.info(hostName);
			System.out.println("Host Name " + InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
		}
	}

}