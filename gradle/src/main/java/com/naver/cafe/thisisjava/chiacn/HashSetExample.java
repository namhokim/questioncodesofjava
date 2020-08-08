package com.naver.cafe.thisisjava.chiacn;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("java");
		set.add("jdbc");
		int size = set.size();

		System.out.println("총 객체 수: " + size);

		Iterator<String> iterator.next();
		//		---------------------- > 1
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		set.remove("jdbc");
		set.remove("ibatis");

		iterator = set.iterator();
		//		------------------------------->2
		for (String element : set) {
			System.out.println("\t" + element);
		}
	}
}
