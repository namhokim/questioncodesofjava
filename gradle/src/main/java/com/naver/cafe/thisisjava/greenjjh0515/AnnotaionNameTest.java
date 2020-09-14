package com.naver.cafe.thisisjava.greenjjh0515;

@AnnotaionName("val")
public class AnnotaionNameTest {
    public static void main(String[] args) {
        AnnotaionNameTest test = new AnnotaionNameTest();
        final Class<? extends AnnotaionNameTest> aClass = test.getClass();
        final AnnotaionName annotation = aClass.getAnnotation(AnnotaionName.class);
        System.out.println(annotation.value());
    }
}
