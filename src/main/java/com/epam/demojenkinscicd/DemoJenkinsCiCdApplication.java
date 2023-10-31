package com.epam.demojenkinscicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoJenkinsCiCdApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoJenkinsCiCdApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoJenkinsCiCdApplication.class);
    }

}
