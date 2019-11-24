package com.naver.cafe.javachobostudy.oung1002;

public class StringEquals {
	public static void main(String[] args) {
		String s1 = "null";
		String s2 = "null";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		s1 = new String("null");
		s2 = new String("null");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

		s1 = null;
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
