package top.aprillie.jms.mail;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:46
 * @Modified By:
 */
public interface MailSender {

    void sendMail(String subject, String from, String to, String params);
}
