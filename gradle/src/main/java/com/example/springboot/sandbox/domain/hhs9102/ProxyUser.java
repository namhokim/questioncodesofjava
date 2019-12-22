package com.example.springboot.sandbox.domain.hhs9102;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProxyUser {
    private String username;
    private boolean isProxyUserByAnnotation = true;
}
