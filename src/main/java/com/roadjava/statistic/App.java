package com.roadjava.statistic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@MapperScan(basePackages = {"com.roadjava.statistic.mapper"})
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
