package com.autumn.common.saToken;

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.fastjson2.JSON;
import com.autumn.common.dictionary.Dictionary;
import com.autumn.common.redis.RedisUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        String premKey = Dictionary.SYSTEM + ":" + Dictionary.PERMS + ":" + loginId;
        Object data = redisUtil.get(premKey);
        List<String> list = data != null ? JSON.parseObject(String.valueOf(data), List.class) : new ArrayList<>();
        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        String roleKey = Dictionary.SYSTEM + ":" + Dictionary.ROLES + ":" + loginId;
        Object data = redisUtil.get(roleKey);
        List<String> list = data != null ? JSON.parseObject(String.valueOf(data), List.class) : new ArrayList<>();
        return list;
    }

}
