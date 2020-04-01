package com.naver.cafe.javachobostudy.kdh959595;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarFormat {
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2019, Calendar.MARCH, 1);

		SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
		String startHourDate = sdf.format(cal.getTime());

		System.out.println(startHourDate);	// 20190301191437
	}
}
