package com.roadjava.statistic.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 权限配置
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Configuration
@ConfigurationProperties(prefix = "auth")
@Data
public class AuthorizationProperties {
    /**
     * 要忽略的url列表
     */
    private List<String> ignoreHandlers;
}
