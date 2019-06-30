package com.imocc.springbootreadlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 开启组件扫描和自动配置
 * 实际上包含了三个有用的注解：
 * 1. @Configuration
 * 2. @ComponentScan
 * 3. @EnableAutoConfiguration  -->@Abracadabra 开启了SpringBoot自动配置
 */
@SpringBootApplication
public class SpringBootReadListApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReadListApplication.class, args);
    }

}
