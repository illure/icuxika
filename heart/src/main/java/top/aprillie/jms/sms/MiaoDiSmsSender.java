package top.aprillie.jms.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import top.aprillie.common.constants.Constants;
import top.aprillie.jms.utils.HttpUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/1 22:50
 * @Modified By:
 */
@Slf4j
@Service("verificationCodeService")
public class MiaoDiSmsSender implements SmsSender {

    private static String operation = "/industrySMS/sendSMS";

    @Override
    public void sendSms(String phone, String tplId, String params) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = sdf.format(new Date());
            String sig = DigestUtils.md5Hex(Constants.MDSMS_ACCOUNT_SID + Constants.MDSMS_AUTH_TOKEN + timestamp);
            String url = Constants.MDSMS_REST_URL + operation;
            Map<String, String> param = new HashMap<>();
            param.put("accountSid", Constants.MDSMS_ACCOUNT_SID);
            param.put("templateid", tplId);
            param.put("param", params);
            param.put("to", phone);
            param.put("timestamp", timestamp);
            param.put("sig", sig);
            param.put("respDataType", "json");
            String result = HttpUtil.post(url, param);
            JSONObject jsonObject = JSON.parseObject(result);
            if (!"00000".equals(jsonObject.getString("respCode"))) {
                log.error("fail to send sms to " + phone + ":" + params + ":" + result);
            }
        } catch (Exception e) {
            log.error("fail to send sms to " + phone + ":" + params);
        }
    }
}
