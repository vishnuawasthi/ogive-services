package com.app.config;

import java.util.Properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootConfiguration
public class ApplicationConfiguration {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		//TODO Change the Host when you get new server details as it is pointing the Gmail right now.
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		// UserDetails
		mailSender.setUsername("vishnu.awasthi.dev9@gmail.com");
		mailSender.setPassword("Secure*123");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		return mailSender;
	}

}
