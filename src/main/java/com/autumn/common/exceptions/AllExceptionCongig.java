package com.autumn.common.exceptions;

import cn.dev33.satoken.exception.DisableServiceException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.autumn.common.result.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class AllExceptionCongig {

    // 全局异常拦截（拦截项目中的所有异常）
    @ResponseBody
    @ExceptionHandler
    public Result handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) {

        // 打印堆栈，以供调试
        e.printStackTrace();

        // 不同异常返回不同状态码
        if (e instanceof NotLoginException) {    // 如果是未登录异常 e.getMessage()
            NotLoginException ee = (NotLoginException) e;
            return Result.failMsg(401, "会话已失效请重新登录");
        } else if (e instanceof NotRoleException) {        // 如果是角色异常 ee.getRole()
            NotRoleException ee = (NotRoleException) e;
            return Result.failMsg("无此角色");
        } else if (e instanceof NotPermissionException) {    // 如果是权限异常 ee.getCode()
            NotPermissionException ee = (NotPermissionException) e;
            return Result.failMsg("权限不足: " + ee.getMessage());
        } else if (e instanceof DisableServiceException) {    // 如果是被封禁异常
            DisableServiceException ee = (DisableServiceException) e;
            return Result.failMsg("账号被封禁：" + ee.getDisableTime() + "秒后解封, 封禁等级：" + ee.getLevel());
        } else if (e instanceof MethodArgumentNotValidException) {    // 传参校验
            MethodArgumentNotValidException ee = (MethodArgumentNotValidException) e;
            return Result.failMsg(ee.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", ")));
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ee = (ConstraintViolationException) e;
            return Result.failMsg(ee.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
        } else {    // 普通异常, 输出：500 + 异常信息
            return Result.failMsg(500, "系统异常：" + e.getMessage());
        }

    }

}
