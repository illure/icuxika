package top.aprillie.module.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.aprillie.module.user.entity.UserAuth;

@Mapper
@Component(value = "userAuthMapper")
public interface UserAuthMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);

    UserAuth selectByIdentifier(String identifier);
}