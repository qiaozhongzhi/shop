package org.wendu.dye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //启用openfeign
@EnableCaching //启用注解式缓存
public class DyeServiceInfoApp {

    public static void main(String[] args) {
        SpringApplication.run(DyeServiceInfoApp.class,args);
    }
}
