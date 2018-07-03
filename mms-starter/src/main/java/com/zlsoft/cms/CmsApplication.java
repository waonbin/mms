package com.zlsoft.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.zlsoft.cms")
@SpringBootApplication
public class CmsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }
}
