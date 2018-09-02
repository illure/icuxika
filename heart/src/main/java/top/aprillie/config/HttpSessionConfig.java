package top.aprillie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import top.aprillie.common.constants.Parameters;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 16:06
 * @Modified By:
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

    @Autowired
    private Parameters parameters;

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

    @Bean
    public JedisConnectionFactory connectionFactory() {

        String redisHost = parameters.getRedisNode().split(":")[0];
        int redisPort = Integer.valueOf(parameters.getRedisNode().split(":")[1]);

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(parameters.getRedisAuth()));
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
}
