package com.app.config;

import java.util.Properties;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootConfiguration

public class ApplicationConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		// TODO Change the Host when you get new server details as it is pointing the
		// Gmail right now.
		mailSender.setHost(environment.getProperty("spring.mail.host"));
		mailSender.setPort(Integer.valueOf(environment.getProperty("spring.mail.port")));
		mailSender.setUsername(environment.getProperty("spring.mail.username"));
		mailSender.setPassword(environment.getProperty("spring.mail.password"));

		Properties props = mailSender.getJavaMailProperties();

		props.put("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
		props.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
		props.put("mail.debug", environment.getProperty("mail.debug"));
		props.put("mail.smtp.ssl.trust", environment.getProperty("mail.smtp.ssl.trust"));
		return mailSender;
	}

	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("WellnessMngt-");
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();
		return executor;
	}

}
