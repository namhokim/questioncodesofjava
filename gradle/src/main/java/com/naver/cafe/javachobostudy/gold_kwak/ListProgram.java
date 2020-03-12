package com.naver.cafe.javachobostudy.gold_kwak;

public class ListProgram {
	String prog = "field";

	public static void main(String[] args) {
		ExamList list = new ExamList();
		list.exams[0] = new Exam();
		list.exams[1] = new Exam();
		list.exams[2] = new Exam();
		list.current = 0;

		ListProgram listProgram = new ListProgram();
		System.out.println(listProgram.prog);
	}
}
