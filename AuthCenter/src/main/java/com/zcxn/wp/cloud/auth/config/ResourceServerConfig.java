package com.zcxn.wp.cloud.auth.config;


import com.zcxn.wp.cloud.auth.EntryPoint.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * <p>参看：https://github.com/spring-guides/tut-spring-security-and-angular-js/blob/master/oauth2-vanilla/README.adoc</p>
 * Created by Mr.Yangxiufeng on 2017/12/29.
 * Time:10:46
 * ProjectName:Mirco-Service-Skeleton
 */
@Configuration
@EnableResourceServer
// @Deprecated
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
            csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(
                new Http401AuthenticationEntryPoint("Bearer realm=\"webrealm\""))
            .and()
            .authorizeRequests().antMatchers("/logout","/code/**").permitAll().anyRequest().authenticated()
            .and()
            .httpBasic();
    }
}



