package top.aprillie.security.authorize;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 13:45
 * @Modified By:
 */
public class RestPreAuthenticatedProcessingFilter extends AbstractPreAuthenticatedProcessingFilter {

    private AntPathMatcher matcher = new AntPathMatcher();

    private List<String> noAuthorizeRequiredPath;

    RestPreAuthenticatedProcessingFilter(List<String> noAuthorizeRequiredPath) {
        this.noAuthorizeRequiredPath = noAuthorizeRequiredPath;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {

        System.out.println("Spring Security 第一步！");

        GrantedAuthority[] authorities = new GrantedAuthority[1];
        // 不需要权限的路径
        if (isNoAuthorizeRequiredPath(httpServletRequest.getRequestURI()) || "".equals(httpServletRequest.getMethod())) {
            GrantedAuthority authority = new SimpleGrantedAuthority("NO_AUTHORIZE_REQUIRED");
            authorities[0] = authority;
            return new RestAuthenticationToken(Arrays.asList(authorities));
        }

        // 需要权限的路径
        // 检查token
        String token = "xxx";
        if (!StringUtils.isBlank(token)) {
            // token 存在 查询权限
        } else {

        }
        return new RestAuthenticationToken(Arrays.asList(authorities));
    }

    private boolean isNoAuthorizeRequiredPath(String uriList) {
        boolean result = false;
        if (!this.noAuthorizeRequiredPath.isEmpty()) {
            for (String pattern : this.noAuthorizeRequiredPath) {
                if (matcher.match(pattern, uriList)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        return null;
    }
}
