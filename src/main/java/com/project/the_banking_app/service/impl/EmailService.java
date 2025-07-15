package com.project.the_banking_app.service.impl;

import com.project.the_banking_app.dto.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
