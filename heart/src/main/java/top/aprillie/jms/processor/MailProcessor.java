package top.aprillie.jms.processor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import top.aprillie.jms.mail.MailSender;

import javax.jms.Destination;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:54
 * @Modified By:
 */
@Component("mailProcessor")
public class MailProcessor {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    @Qualifier("qqMailService")
    private MailSender mailSender;

    public void sendMailToQueue(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination = "mail.queue")
    public void doSendMail(String mail) {
        JSONObject jsonObject = JSONObject.parseObject(mail);
        mailSender.sendMail(jsonObject.getString("to"), jsonObject.getString("params"));
    }
}
