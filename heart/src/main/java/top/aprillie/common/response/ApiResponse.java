package top.aprillie.common.response;

import lombok.Data;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 15:50
 * @Modified By:
 */
@Data
public class ApiResponse<T> {

    private int code;

    private T data;

    private String message;

    public ApiResponse() {
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
