package com.naver.cafe.javachobostudy.hhs9102;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateWithReadTimeout {
    public RestTemplate getRestTemplate(int readTimeout) {
        return new RestTemplate((uri, httpMethod) -> {
            SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
            simpleClientHttpRequestFactory.setReadTimeout(readTimeout);
            return simpleClientHttpRequestFactory.createRequest(uri, httpMethod);
        });
    }
}
