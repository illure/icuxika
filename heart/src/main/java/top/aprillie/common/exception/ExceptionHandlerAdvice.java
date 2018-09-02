package top.aprillie.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.aprillie.common.constants.Constants;
import top.aprillie.common.response.ApiResponse;

import java.util.List;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 15:48
 * @Modified By:
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ApiResponse handlerException(Exception e) {
        log.error(e.getMessage(), e);
        return new ApiResponse(Constants.RESPONSE_STATUS_INTERNAL_ERROR, "系统异常，请稍后重新尝试！");
    }

    @ExceptionHandler(HeartException.class)
    public ApiResponse handlerException(HeartException e) {
        log.error(e.getMessage(), e);
        return new ApiResponse(Constants.RESPONSE_STATUS_INTERNAL_ERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handlerIllegalParamException(MethodArgumentNotValidException e) {
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = "参数不合法！";
        if (errors.size() > 0) {
            message = errors.get(0).getDefaultMessage();
        }
        ApiResponse response = new ApiResponse(Constants.RESPONSE_STATUS_INTERNAL_ERROR, message);
        return response;
    }
}
