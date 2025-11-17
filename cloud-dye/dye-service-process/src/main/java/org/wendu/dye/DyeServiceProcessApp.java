package org.wendu.dye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //启用openfeign
public class DyeServiceProcessApp {

    public static void main(String[] args) {
        SpringApplication.run(DyeServiceProcessApp.class,args);
    }
}
