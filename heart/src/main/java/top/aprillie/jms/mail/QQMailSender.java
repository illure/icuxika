package top.aprillie.jms.mail;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import top.aprillie.common.constants.Constants;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:46
 * @Modified By:
 */
@Slf4j
@Service("qqMailService")
public class QQMailSender implements MailSender {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendMail(String to, String params) {
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject(Constants.MAIL_SUBJECT);
            helper.setFrom(Constants.MAIL_FROM);
            helper.setTo(to);

            JSONObject jsonObject = JSONObject.parseObject(params);
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put("nickname", jsonObject.getString("nickname"));
            paramsMap.put("verificationCode", jsonObject.getString("verificationCode"));

            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setClassForTemplateLoading(this.getClass(), "/templates");
            Template template = configuration.getTemplate("email.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, paramsMap);

            helper.setText(html, true);
        } catch (Exception e) {
            log.error("Fail to send mail", e);
        }
        javaMailSender.send(message);
    }
}
