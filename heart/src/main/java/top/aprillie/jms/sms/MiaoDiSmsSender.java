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

    @Override
    public void sendSms(String to, String param) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = sdf.format(new Date());
            String sig = DigestUtils.md5Hex(Constants.MDSMS_ACCOUNT_SID + Constants.MDSMS_AUTH_TOKEN + timestamp);
            String url = Constants.MDSMS_BASE_URL + Constants.MDSMS_INDUSTRY_OPERATION;
            Map<String, String> params = new HashMap<>();
            params.put("accountSid", Constants.MDSMS_ACCOUNT_SID);
            params.put("templateid", Constants.MDSMS_VERIFICATION_CODE_TPLID);
            params.put("param", param);
            params.put("to", to);
            params.put("timestamp", timestamp);
            params.put("sig", sig);
            params.put("respDataType", "json");
            String result = HttpUtil.post(url, params);
            JSONObject jsonObject = JSON.parseObject(result);
            if (!Constants.MDSMS_RESP_CODE_OK.equals(jsonObject.getString("respCode"))) {
                log.error("Fail to send sms to " + to + ":" + param + ":" + result);
            }
        } catch (Exception e) {
            log.error("Fail to send sms to " + to + ":" + param);
        }
    }
}
