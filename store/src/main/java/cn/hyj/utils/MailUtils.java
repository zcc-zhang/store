package cn.hyj.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * 邮箱工具类
 */
@Component("mailUtils")
public class MailUtils {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public JavaMailSenderImpl getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    /***
     * 发送邮件
     * @param receiveMailAccount 收件人
     * @param mailActiveCode 验证码
     */
    public void sendActiveMail(String receiveMailAccount, String mailActiveCode){

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(receiveMailAccount);
        simpleMailMessage.setFrom(mailSender.getUsername());
        simpleMailMessage.setText("123456");
        try {
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
