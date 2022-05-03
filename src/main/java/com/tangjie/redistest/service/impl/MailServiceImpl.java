package com.tangjie.redistest.service.impl;

import com.tangjie.redistest.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Override
    public void sendMail(String title, String content, String[] to,String[] cc) {
        // 构建一个邮件对象
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置邮件主题
        simpleMailMessage.setSubject(title);
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        simpleMailMessage.setFrom("souptj@163.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        simpleMailMessage.setTo(to);
        // 设置邮件抄送人，可以有多个抄送人
        simpleMailMessage.setCc(cc);
        // 设置隐秘抄送人，可以有多个
//        simpleMailMessage.setBcc("souptj@163.com");
        // 设置邮件发送日期
        simpleMailMessage.setSentDate(new Date());
        // 设置邮件的正文
        simpleMailMessage.setText(content);
        // 发送邮件
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sendThymeleafMail(String title, String content, String... to) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject(title);
        helper.setFrom("souptj@163.com");
        helper.setTo(to);
//        helper.setCc("37xxxxx37@qq.com");
//        helper.setBcc("14xxxxx098@qq.com");
        helper.setSentDate(new Date());
        // 这里引入的是Template的Context
        Context context = new Context();
        // 设置模板中的变量
        context.setVariable("username", "施老板");
        context.setVariable("num", "000001");
        context.setVariable("salary", "888888");
        // 第一个参数为模板的名称
        String process = templateEngine.process("mail.html", context);
        // 第二个参数true表示这是一个html文本
        helper.setText(process, true);
        javaMailSender.send(mimeMessage);
    }
}
