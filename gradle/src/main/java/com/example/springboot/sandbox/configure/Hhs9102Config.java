package com.example.springboot.sandbox.configure;

import com.example.springboot.sandbox.domain.hhs9102.ProxyUser;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Hhs9102Config {
    @Bean
    //프록시 대상
    public ProxyUser proxyUserByAnnotation(){
        ProxyUser proxyUser = new ProxyUser();
        proxyUser.setUsername("username");
        return proxyUser;
    }

    @Bean
    //포이트컷
    public Pointcut upperPointcutByAnnotation(){
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("getUsername");
        pointcut.setClassFilter(clazz -> clazz.getName().indexOf("ProxyUser")>-1);
        return pointcut;
    }

    @Bean
    //어드바이스
    public MethodInterceptor upperAdviceByAnnotation(){
        return invocation -> {
            return invocation.proceed().toString().toUpperCase();
        };
    }


    @Bean
    //어드바이저 검색 및 등록을 위한 빈등록
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    //어드바이저 생성 = 포인트컷 + 어드바이스
    public DefaultPointcutAdvisor upperAdvisorByAnnotation(Pointcut upperPointcutByAnnotation,
                                                           MethodInterceptor upperAdviceByAnnotation){
        return new DefaultPointcutAdvisor(upperPointcutByAnnotation, upperAdviceByAnnotation) ;
    }

    @Bean
    //프록시 팩토리빈 등록
    public ProxyFactoryBean proxyFactoryBean(ProxyUser proxyUserByAnnotation){
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(proxyUserByAnnotation);
        proxyFactoryBean.setInterceptorNames(new String[]{"upperAdvisorByAnnotation"});
        return proxyFactoryBean;
    }
}
