package com.lambdaschool.schools.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SwaggerWebMVC implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui/html").addResourceLocations("classpath:/META-ING/resources/");
        registry.addResourceHandler("swagger-ui/html").addResourceLocations("classpath:/META-ING/resources/webjars/");
    }
}
