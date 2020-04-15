package com.planner.calc.service.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	public void sendEmail(String to, String subject, String text);
}
