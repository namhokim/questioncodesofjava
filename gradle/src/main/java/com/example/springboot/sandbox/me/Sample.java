package com.example.springboot.sandbox.me;

import java.util.Objects;

class Sample {
    boolean before(String str1, String str2) {
        return str1 != null && str1.equals(str2);
    }

    boolean later(String str1, String str2) {
        return Objects.equals(str1, str2);
    }
}
