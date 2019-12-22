package com.example.springboot.sandbox.configure;

import com.example.springboot.sandbox.domain.hhs9102.ProxyUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@DisplayName("annotation 을 이용한 bean등록")
class Hhs9102ConfigTest {
    @Autowired
    ProxyUser proxyUserByAnnotation;

    @Test
    @DisplayName("프록시가 잘 생성되는지 확인")
    public void proxyUserTset(){
        assertEquals("USERNAME", proxyUserByAnnotation.getUsername());
        assertEquals(true, proxyUserByAnnotation.isProxyUserByAnnotation());
    }
}
