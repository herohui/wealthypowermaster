package com.zcxn.wp.cloud.common.bean.config;

import com.google.common.collect.Maps;
import com.zcxn.wp.cloud.common.xssfilter.XssFilter;
import java.util.Map;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XssConfig {

  @Bean
  public FilterRegistrationBean xssFilterRegistrationBean() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new XssFilter());
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.setEnabled(true);
    filterRegistrationBean.addUrlPatterns("/*");
    Map<String, String> initParameters = Maps.newHashMap();
    initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
    initParameters.put("isIncludeRichText", "true");
    filterRegistrationBean.setInitParameters(initParameters);
    return filterRegistrationBean;
  }


}
