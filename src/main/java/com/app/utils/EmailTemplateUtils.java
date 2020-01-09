package com.app.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.app.dto.EmailDetailDTO;

import freemarker.template.Configuration;

@Component
public class EmailTemplateUtils {

	@Autowired
	private Configuration freemarkerConfig;

	public String prepareEmailBody(EmailDetailDTO emailDetailDTO) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("title", "Dear Customer");
		model.put("body", emailDetailDTO.getBodyText());
		model.put("signature", emailDetailDTO.getSignature());
		String body = geContentFromTemplate(model);
		return body;
	}

	public String geContentFromTemplate(Map<String, Object> model) {
		StringBuffer content = new StringBuffer();
		try {
			content.append(FreeMarkerTemplateUtils
					.processTemplateIntoString(freemarkerConfig.getTemplate("UserRegistrationFeedback.ftl"), model));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

}
