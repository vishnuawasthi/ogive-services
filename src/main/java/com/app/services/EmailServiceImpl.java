package com.app.services;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.dto.EmailDetailDTO;
import com.app.utils.EmailTemplateUtils;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	private EmailTemplateUtils emailTemplateUtils;

	@Override
	public void sendEmail(String subject, String body, String toEmail, String ccEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setCc(ccEmail);
		message.setSubject(subject);
		message.setText(body);
		emailSender.send(message);
	}

	@Override
	public void sendEmail(EmailDetailDTO emailDetailDTO) {

		SimpleMailMessage message = new SimpleMailMessage();
		String[] toArrays = new String[emailDetailDTO.getToEmails().size()];
		message.setTo(emailDetailDTO.getToEmails().toArray(toArrays));
		
		String[] ccArrays = new String[emailDetailDTO.getBccEmails().size()];
		message.setCc(emailDetailDTO.getCcEmails().toArray(ccArrays));
		
		String[] bccArrays = new String[emailDetailDTO.getBccEmails().size()];
		message.setBcc(emailDetailDTO.getBccEmails().toArray(bccArrays));
		
		message.setSubject(emailDetailDTO.getSubject());

		message.setText(emailTemplateUtils.prepareEmailBody(emailDetailDTO));
		emailSender.send(message);

	}

	@Override
	public void sendEmailWithHtmlTemplate(EmailDetailDTO emailDetailDTO) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.setText(emailTemplateUtils.prepareEmailBody(emailDetailDTO), true);
		String[] toArrays = new String[emailDetailDTO.getToEmails().size()];
		helper.setTo(emailDetailDTO.getToEmails().toArray(toArrays));
		
		String[] ccArrays = new String[emailDetailDTO.getBccEmails().size()];
		helper.setCc(emailDetailDTO.getCcEmails().toArray(ccArrays));
		
		String[] bccArrays = new String[emailDetailDTO.getBccEmails().size()];
		helper.setBcc(emailDetailDTO.getBccEmails().toArray(bccArrays));
		emailSender.send(message);
		
		
	}

}
