package top.aprillie.jms.utils;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.aprillie.common.constants.Constants;
import top.aprillie.jms.processor.SmsProcessor;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:58
 * @Modified By:
 */
@Component
public class SmsUtils {

    @Autowired
    private SmsProcessor smsProcessor;

    public void sendVerificationSms(String to, String verificationCode) {
        Destination destination = new ActiveMQQueue("sms.queue");
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("to", to);
        paramsMap.put("verificationCode", verificationCode);
        String message = JSON.toJSONString(paramsMap);
        smsProcessor.sendSmsToQueue(destination, message);
    }
}
