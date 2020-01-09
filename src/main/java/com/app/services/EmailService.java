package com.app.services;

import javax.mail.MessagingException;

import com.app.dto.EmailDetailDTO;

public interface EmailService {

	public void sendEmail(String subject, String body, String toEmail, String ccEmail);
	
	//EmailTemplateUtils
	public void sendEmail(EmailDetailDTO emailDetailDTO);
	
	public void sendEmailWithHtmlTemplate(EmailDetailDTO emailDetailDTO) throws MessagingException;
	
	

}
