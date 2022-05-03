package com.tangjie.redistest.service;

import javax.mail.MessagingException;
import java.util.List;

public interface MailService {
    void sendMail(String title, String content, String[] to, String[] cc);

    void sendThymeleafMail(String title, String content, String... to) throws MessagingException;
}
