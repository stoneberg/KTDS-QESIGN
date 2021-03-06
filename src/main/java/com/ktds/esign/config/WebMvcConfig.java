package com.ktds.esign.config;

import com.ktds.esign.common.filters.RequestBodyFilter;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final String uploadFilePath;

    public WebMvcConfig(@Value("${app.file.location}") String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/files/**") // every file request
                .addResourceLocations("file://" + uploadFilePath); // find this location
    }

    /**
     * Set restTemplate timeout to 10 seconds
     * (Default is unlimited)
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofMillis(10_000))
                .setReadTimeout(Duration.ofMillis(10_000))
                .build();
    }

    /**
     * Naver Lucy XSS Filter(Form Parameter)
     */
    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> xssEscapeServletFilter(){
        FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }


    /**
     * RequestBody XSS Filter(JSON RequestBody)
     */
    @Bean
    public FilterRegistrationBean<RequestBodyFilter> xssEscapeRequestBodyFilter(){
        FilterRegistrationBean<RequestBodyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestBodyFilter());
        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
