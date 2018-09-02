package top.aprillie.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import top.aprillie.common.constants.Parameters;

/**
 * @Author: illure
 * @Description: Spring Security 配置类
 * @Date: Created in 2018/9/2 13:14
 * @Modified By:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private Parameters parameters;

    private RestPreAuthenticatedProcessingFilter getPreAuthenticatedProcessingFilter() throws Exception {
        RestPreAuthenticatedProcessingFilter filter = new RestPreAuthenticatedProcessingFilter(parameters.getNoAuthorizeRequiredPath());
        filter.setAuthenticationManager(this.authenticationManagerBean());
        return filter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new RestAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(parameters.getNoAuthorizeRequiredPath().toArray(new String[parameters.getNoAuthorizeRequiredPath().size()])).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .addFilter(getPreAuthenticatedProcessingFilter())
        ;
    }

    @Override
    public void init(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
