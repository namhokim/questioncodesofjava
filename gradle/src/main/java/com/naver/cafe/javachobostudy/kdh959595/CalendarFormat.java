package com.naver.cafe.javachobostudy.kdh959595;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarFormat {
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmmss);
		cal.set(2019, 2, 1);
		String startHourDate = sdf.format(cal.getTime());

		System.out.println(startHourDate);
	}
}
