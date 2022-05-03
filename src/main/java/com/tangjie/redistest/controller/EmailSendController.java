package com.tangjie.redistest.controller;


import com.tangjie.redistest.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class EmailSendController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public String sendMail(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("to") String[] to, @RequestParam("cc") String[] cc) throws Exception {
        String result = "发送成功";
        mailService.sendMail(title, content, to, cc);
        return result;
    }


    @RequestMapping(value = "/sendThymeleafMail", method = RequestMethod.POST)
    @ResponseBody
    public String sendThymeleafMail(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("to") String... to) throws Exception {
        String result = "发送成功";
        mailService.sendThymeleafMail(title, content, to);
        return result;
    }
}
