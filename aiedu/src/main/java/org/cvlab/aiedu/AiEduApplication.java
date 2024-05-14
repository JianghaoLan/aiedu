package org.cvlab.aiedu;

import com.ruoyi.common.security.annotation.EnableCustomConfig;
import com.ruoyi.common.security.annotation.EnableRyFeignClients;
import com.ruoyi.common.security.config.ApplicationConfig;
import com.ruoyi.common.security.feign.FeignAutoConfiguration;
import com.ruoyi.common.swagger.annotation.EnableCustomSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

//@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients(basePackages = {"org.cvlab", "com.ruoyi"})
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
// 指定要扫描的Mapper类的包的路径
@MapperScan("org.cvlab.aiedu.mapper")
// 开启线程异步执行
@EnableAsync
@Import({ ApplicationConfig.class, FeignAutoConfiguration.class })
@SpringBootApplication
public class AiEduApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiEduApplication.class, args);
    }
}
