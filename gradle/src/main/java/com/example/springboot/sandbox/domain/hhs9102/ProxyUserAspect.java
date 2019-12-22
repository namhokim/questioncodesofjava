package com.example.springboot.sandbox.domain.hhs9102;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProxyUserAspect {
    @Around("execution(* com.example.springboot.sandbox.domain.hhs9102.ProxyUser.getUsername())")
    public Object upper(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed().toString().toUpperCase();
    }
}
