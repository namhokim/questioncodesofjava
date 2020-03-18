package com.naver.cafe.javachobostudy.intelryzen;

public class StringTest {
	public static void main(String[] args) {
		String str1 = getStringAppend();
		String str2 = getStringWithOnline();
		System.out.println(str1 == str2);
	}

	private static String getStringAppend() {
		String str = "안녕";
		str += "자바";
		str += "!";
		return str;
	}

	private static String getStringWithOnline() {
		String str = "안녕" + "자바" + "!";
		return str;
	}
}
