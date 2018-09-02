package top.aprillie.security.authorize;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 13:48
 * @Modified By:
 */
public class RestAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("Spring Security 第三步！授权！");

        if (authentication instanceof PreAuthenticatedAuthenticationToken) {

        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {

        System.out.println("Spring Security 第二步！");

        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(aClass)
                || RestAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
