package com.logronj.services;

import com.logronj.models.EmailDto;

public interface EmailService {

	void sendEmail(EmailDto emailDto);
	
}
