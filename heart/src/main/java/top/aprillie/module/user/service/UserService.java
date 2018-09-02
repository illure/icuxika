package top.aprillie.module.user.service;

import top.aprillie.common.exception.HeartException;
import top.aprillie.module.user.entity.UserAuth;
import top.aprillie.module.user.entity.UserElement;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 16:42
 * @Modified By:
 */
public interface UserService {
    /**
     *
     * @author: illure
     * @date: 2018/9/2 17:20
     * @param: [userAuth] 用户登陆所输入的账户标识符与凭证
     * @return: top.aprillie.module.user.entity.UserElement
     */
    UserElement login(UserAuth userAuth) throws HeartException;

    /**
     *
     * @author: illure
     * @date: 2018/9/2 17:37
     * @param: [userAuth] 用户注册所输入的账户标识符与凭证
     * @return: void
     */
    void register(UserAuth userAuth) throws HeartException;
}
