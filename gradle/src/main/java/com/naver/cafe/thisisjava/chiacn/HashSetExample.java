package com.naver.cafe.thisisjava.chiacn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		int size = set.size();

		Iterator<String> iterator = set.iterator();    // Iterator 를 이용한 loop
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		System.out.println("총 객체 수: " + size);

		set.remove("jdbc");
		set.remove("ibatis");

		for (String element : set) {	    // enhanced for 를 이용한 loop
			System.out.println("\t" + element);
		}
	}
}
