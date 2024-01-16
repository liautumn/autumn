package com.autumn.web.user.mapper;

import com.autumn.web.user.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

/**
 * @author lqz
 * @date 2023-07-10 15:27:07
 * 用户信息 Mapper
 */
public interface UserMapper extends BaseMapper<User> {

    @MapKey("id")
    Map getInfoById(String id);

}
