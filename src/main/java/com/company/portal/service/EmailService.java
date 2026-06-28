package com.company.portal.service;

import com.company.portal.model.h2.Email;
import com.company.portal.repository.h2.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Email> getTop5Emails(String receiver) {
        return emailRepository.findTop5ByReceiver(receiver);
    }

    public void saveEmail(Email email) {
        emailRepository.save(email);
    }
}

