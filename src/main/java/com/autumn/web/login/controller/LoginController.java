package com.autumn.web.login.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.autumn.common.dictionary.Dictionary;
import com.autumn.common.redis.RedisUtil;
import com.autumn.common.result.Result;
import com.autumn.common.saToken.LoginInfoData;
import com.autumn.web.login.entity.LoginDto;
import com.autumn.web.login.entity.LoginUserInsertDto;
import com.autumn.web.login.entity.LoginUserUpdateDto;
import com.autumn.web.login.entity.PasswordDto;
import com.autumn.web.user.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

@RestController
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;

    /**
     * 登录
     *
     * @param login
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody @Validated LoginDto login) {
        return userService.login(login);
    }

    /**
     * 登出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result logout() {
        // 清空缓存权限
        String loginId = LoginInfoData.getUserInfo().getId();
        String premKey = Dictionary.SYSTEM + ":" + Dictionary.PERMS + ":" + loginId;
        redisUtil.remove(premKey);
        String roleKey = Dictionary.SYSTEM + ":" + Dictionary.ROLES + ":" + loginId;
        redisUtil.remove(roleKey);
        // 登出
        StpUtil.logout();
        return Result.success();
    }

    /**
     * 注册
     *
     * @param userInsertDto
     * @return
     */
    @PostMapping("/signUp")
    public Result signUp(@RequestBody @Validated LoginUserInsertDto userInsertDto) {
        return userService.loginInsertUser(userInsertDto);
    }

    /**
     * 注销
     *
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam("id") @NotBlank(message = "id不能为空") String id) {
        return userService.loginDeleteUser(id);
    }

    /**
     * 修改信息
     *
     * @param userUpdateDto
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody @Validated LoginUserUpdateDto userUpdateDto) {
        return userService.loginUpdateUser(userUpdateDto);
    }

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getOneUser")
    public Result getOneUser(@RequestParam("id") @NotBlank(message = "id不能为空") String id) {
        return userService.getOneUser(id);
    }

    /**
     * 修改密码
     *
     * @param passwordDto
     * @return
     */
    @PostMapping("/updatePassword")
    public Result updatePassword(@RequestBody @Validated PasswordDto passwordDto) {
        return userService.updatePassword(passwordDto);
    }

}
