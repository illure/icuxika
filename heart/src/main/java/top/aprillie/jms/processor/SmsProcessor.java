package top.aprillie.jms.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import top.aprillie.jms.sms.SmsSender;

import javax.jms.Destination;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:56
 * @Modified By:
 */
@Component("smsProcessor")
public class SmsProcessor {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    @Qualifier("verificationCodeService")
    private SmsSender smsSender;

    public void sendSmsToQueue(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination = "sms.queue")
    public void  doSendSmsMessage(String note) {
        JSONObject jsonObject = JSON.parseObject(note);
        smsSender.sendSms(jsonObject.getString("phone"), jsonObject.getString("tplId"), jsonObject.getString("verificationCode"));
    }
}
