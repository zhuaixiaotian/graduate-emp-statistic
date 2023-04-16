package com.roadjava.statistic.config;

import com.roadjava.statistic.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AuthorizationProperties authorizationProperties;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/major/toManage").setViewName("school/major/manage");
        registry.addViewController("/major/toAdd").setViewName("school/major/add");
        registry.addViewController("/clazz/toManage").setViewName("school/clazz/manage");
        registry.addViewController("/clazz/toAdd").setViewName("school/clazz/add");
        registry.addViewController("/student/toManage").setViewName("school/student/manage");
        registry.addViewController("/student/toAdd").setViewName("school/student/add");
        registry.addViewController("/company/toManage").setViewName("enterprise/company/manage");
        registry.addViewController("/company/toAdd").setViewName("enterprise/company/add");
        registry.addViewController("/job/toManage").setViewName("enterprise/job/manage");
        registry.addViewController("/job/toAdd").setViewName("enterprise/job/add");
        registry.addViewController("/statistic/toManage").setViewName("statistic/statistic");
    }

    @Bean
    public AuthInterceptor authInterceptor(){
        return  new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器
        registry
                .addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(authorizationProperties.getIgnoreHandlers())
        ;

    }
}
