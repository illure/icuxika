package top.aprillie.security.authorize;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 14:23
 * @Modified By:
 */
public class RestAuthenticationToken extends AbstractAuthenticationToken {
    public RestAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
