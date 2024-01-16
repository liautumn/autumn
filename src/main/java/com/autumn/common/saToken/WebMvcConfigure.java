package com.autumn.common.saToken;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigure implements WebMvcConfigurer {

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> StpUtil.checkLogin()))
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/logout", "/signUp", "/captcha/get", "/captcha/check");
        /**
         * @SaCheckLogin: 登录校验 —— 只有登录之后才能进入该方法。
         * @SaCheckRole("admin"): 角色校验 —— 必须具有指定角色标识才能进入该方法。
         * @SaCheckPermission("user:add"): 权限校验 —— 必须具有指定权限才能进入该方法。
         * @SaCheckSafe: 二级认证校验 —— 必须二级认证之后才能进入该方法。
         * @SaCheckBasic: HttpBasic校验 —— 只有通过 Basic 认证后才能进入该方法。
         * @SaIgnore：忽略校验 —— 表示被修饰的方法或类无需进行注解鉴权和路由拦截器鉴权。
         * @SaCheckDisable("comment")：账号服务封禁校验 —— 校验当前账号指定服务是否被封禁。
         */
        // 注册Sa-Token的注解拦截器，打开注解式鉴权功能
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }

    /**
     * 开发中遇到前端请求后端保存接口的时候 出现JSON parse error: Unrecognized field "xxx"的错误。
     *
     * @return
     */
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper objectMapper = new ObjectMapper();
//        //添加此配置
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        converter.setObjectMapper(objectMapper);
//        return converter;
//    }

}
