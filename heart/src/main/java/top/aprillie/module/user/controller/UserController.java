package top.aprillie.module.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aprillie.common.constants.Constants;
import top.aprillie.common.exception.HeartException;
import top.aprillie.common.response.ApiResponse;
import top.aprillie.module.user.entity.UserAuth;
import top.aprillie.module.user.entity.UserElement;
import top.aprillie.module.user.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 15:55
 * @Modified By:
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ApiResponse login(@RequestBody @Valid UserAuth userAuth, HttpSession session) throws HeartException {
        ApiResponse<UserElement> result = new ApiResponse<>(Constants.RESPONSE_STATUS_OK, "登陆成功！");
        UserElement userElement = userService.login(userAuth);
        if (userElement != null) {
            if (session.getAttribute(Constants.REQUEST_USER_SESSION) == null) {
                session.setAttribute(Constants.REQUEST_USER_SESSION, userElement);
            }
            result.setData(userElement);
        }
        return result;
    }

    @RequestMapping("/reigster")
    public ApiResponse register(@RequestBody @Valid UserAuth userAuth) throws HeartException {

        userService.register(userAuth);

        return new ApiResponse(Constants.RESPONSE_STATUS_OK, "注册成功！");
    }
}
