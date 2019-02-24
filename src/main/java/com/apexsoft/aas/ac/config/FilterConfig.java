package com.apexsoft.aas.ac.config;

import com.apexsoft.aas.ac.AcBizApply;
import com.apexsoft.aas.ac.filter.AcFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linqz
 * @date 10/11/2018
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean acFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new AcFilter());
        registration.addUrlPatterns("/*");
        registration.setName("acFilter");
        registration.setOrder(1);
        return registration;
  

    }
}
