package com.example.springboot.sandbox.configure;

import com.example.springboot.sandbox.domain.hhs9102.ProxyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class Hhs9102Config {
    @Bean
    //프록시 대상
    public ProxyUser proxyUserByAnnotation(){
        ProxyUser proxyUser = new ProxyUser();
        proxyUser.setUsername("username");
        return proxyUser;
    }
}
