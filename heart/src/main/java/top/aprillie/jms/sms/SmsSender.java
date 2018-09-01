package top.aprillie.jms.sms;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:50
 * @Modified By:
 */
public interface SmsSender {

    void sendSms(String phone, String tplId, String params);
}
