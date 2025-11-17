package org.wendu.dye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DyeServiceSecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(DyeServiceSecurityApp.class,args);
    }
}
