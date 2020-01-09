package com.app.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EmailDetailDTO {

	private Set<String> toEmails;

	private Set<String> ccEmails;

	private Set<String> bccEmails;

	private String bodyText;

	private String subject;

	private String signature;

	public Set<String> getToEmails() {

		if (Objects.isNull(toEmails)) {
			return new HashSet<String>();
		}

		return toEmails;
	}

	public void setToEmails(Set<String> toEmails) {
		this.toEmails = toEmails;
	}

	public Set<String> getCcEmails() {

		if (Objects.isNull(ccEmails)) {
			return new HashSet<String>();
		}
		return ccEmails;
	}

	public void setCcEmails(Set<String> ccEmails) {
		this.ccEmails = ccEmails;
	}

	public Set<String> getBccEmails() {

		if (Objects.isNull(bccEmails)) {
			return new HashSet<String>();
		}
		return bccEmails;
	}

	public void setBccEmails(Set<String> bccEmails) {
		this.bccEmails = bccEmails;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "EmailDetailDTO [toEmails=" + toEmails + ", ccEmails=" + ccEmails + ", bccEmails=" + bccEmails
				+ ", bodyText=" + bodyText + ", subject=" + subject + ", signature=" + signature + "]";
	}

}
