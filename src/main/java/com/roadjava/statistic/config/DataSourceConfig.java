package com.roadjava.statistic.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;
/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    /**
     * 数据源配置分页插件
     */
    @PostConstruct
    public void addPageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.put("helperDialect","mysql");
        properties.put("reasonable","true");
        properties.put("autoRuntimeDialect","false");
        interceptor.setProperties(properties);
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
        }
    }
}
