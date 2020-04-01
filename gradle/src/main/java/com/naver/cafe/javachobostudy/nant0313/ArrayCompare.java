package com.naver.cafe.javachobostudy.nant0313;

public class ArrayCompare {
	public static void main(String[] args) {
		String[] abc = { "co", "ro", "na" };
		String[] bcd = { "co", "ro", "na" };

		if (abc[0] == bcd[0]) {
			System.out.println("true");
		}

		if (abc[0].equals(bcd[0])) {
			System.out.println("true");
		}
	}
}
