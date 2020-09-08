package com.naver.cafe.thisisjava.greenjjh0515;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotaionName {
    String value();
}
