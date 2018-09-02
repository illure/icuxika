package top.aprillie.module.user.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/9/2 16:46
 * @Modified By:
 */
@Data
public class UserElement implements Serializable {

    private Long id;

    private Long userId;

    private Byte identityType;

    private String identifier;

}
