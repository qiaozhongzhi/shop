package org.wendu.dye.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

//开发一个  配置类，可以配置自定义首页等
@Configuration

//通过注解@ServletComponentScan配置在org.wendu.wdoa.common包下扫描过滤器
@ServletComponentScan("org.wendu.dye.common")
public class ServiceCommonConfig {


}
