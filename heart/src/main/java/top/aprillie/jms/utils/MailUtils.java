package top.aprillie.jms.utils;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.aprillie.common.constants.Constants;
import top.aprillie.jms.processor.MailProcessor;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:57
 * @Modified By:
 */
@Component
public class MailUtils {

    @Autowired
    private MailProcessor mailProcessor;

    public void sendVerificationMail(String to, String nickname, String verificationCode) {
        Destination destination = new ActiveMQQueue("mail.queue");

        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("nickname", nickname);
        paramsMap.put("verificationCode", verificationCode);
        String params = JSON.toJSONString(paramsMap);

        Map<String, String> mailParams = new HashMap<>();
        mailParams.put("to", to);
        mailParams.put("params", params);
        String mail = JSON.toJSONString(mailParams);
        mailProcessor.sendMailToQueue(destination, mail);
    }
}
