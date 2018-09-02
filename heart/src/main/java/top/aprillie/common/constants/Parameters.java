package top.aprillie.common.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 13:38
 * @Modified By:
 */
@Component
@Data
public class Parameters {

    @Value("#{'${security.noAuthorizeRequiredPath}'.split(',')}")
    private List<String> noAuthorizeRequiredPath;

    @Value("${redis.node}")
    private String redisNode;

    @Value("${redis.auth}")
    private String redisAuth;

}
