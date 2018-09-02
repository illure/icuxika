package top.aprillie.module.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.aprillie.common.constants.Constants;
import top.aprillie.common.exception.HeartException;
import top.aprillie.module.user.dao.UserAuthMapper;
import top.aprillie.module.user.dao.UserMapper;
import top.aprillie.module.user.entity.User;
import top.aprillie.module.user.entity.UserAuth;
import top.aprillie.module.user.entity.UserElement;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 16:42
 * @Modified By:
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserElement login(UserAuth userAuth) throws HeartException {
        UserElement userElement = null;
        UserAuth existUser = userAuthMapper.selectByIdentifier(userAuth.getIdentifier());
        if (existUser == null) {
            throw new HeartException("用户名或者密码错误！");
        } else {
            boolean result = passwordEncoder.matches(userAuth.getCredential(), existUser.getCredential());
            if (!result) {
                throw new HeartException("用户名或者密码错误！");
            } else {
                userElement = new UserElement();
                userElement.setId(existUser.getId());
                userElement.setUserId(existUser.getUserId());
                userElement.setIdentityType(existUser.getIdentityType());
                userElement.setIdentifier(existUser.getIdentifier());
            }
        }
        return userElement;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void register(UserAuth userAuth) throws HeartException {
        UserAuth existUser = userAuthMapper.selectByIdentifier(userAuth.getIdentifier());
        if (existUser != null) {
            throw new HeartException("该账户已被注册！");
        } else {
            UserAuth account = new UserAuth();
            account.setIdentityType(userAuth.getIdentityType());
            account.setVerification(true);
            account.setIdentifier(userAuth.getIdentifier());
            account.setCredential(passwordEncoder.encode(userAuth.getCredential()));

            User user = new User();
            user.setNickname(userAuth.getIdentifier());
            if (userAuth.getIdentityType().equals(Constants.IDENTIFIER_TYPE_PHONE)) {
                user.setEmail(userAuth.getIdentifier());
            } else if (userAuth.getIdentityType().equals(Constants.IDENTIFIER_TYPE_EMAIL)) {
                user.setPhone(userAuth.getIdentifier());
            }
            // 此处获得 id
            int result1 = userMapper.insertSelective(user);

            if (result1 == 0) {
                throw new HeartException("注册失败，请稍后尝试！");
            }

            // 关联 user 表与 user_auth 表
            account.setUserId(user.getId());
            int result2 = userAuthMapper.insertSelective(account);
            if (result2 == 0) {
                throw new HeartException("注册失败，请稍后尝试！");
            }
        }
    }
}
