package org.unibl.etf.enums;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		DayInWeek day = DayInWeek.FRIDAY;
		System.out.println("------------------------------");
		System.out.println(day);
		if (day == DayInWeek.FRIDAY) {
			System.out.println("Equal");
			System.out.println(DayInWeek.FRIDAY);
		}
		if (day.equals(DayInWeek.FRIDAY)) {
			System.out.println("Equal");
		}
		if (day != DayInWeek.MONDAY) {
			System.out.println("Not equal");
		}
		switch (day) {
		case MONDAY:
			System.out.println("First day in week");
			break;
		case TUESDAY:
			System.out.println("Second day in week");
			break;
		case WEDNESDAY:
			System.out.println("Third day in week");
			break;
		case THURSDAY:
			System.out.println("Fourth day in week");
			break;
		case FRIDAY:
			System.out.println("Fifth day in week");
			break;
		case SATURDAY:
			System.out.println("Sixth day in week");
			break;
		case SUNDAY:
			System.out.println("Seventh day in week");
			break;
		}
		for (DayInWeek dayInWeek : DayInWeek.values()) {
			System.out.println(dayInWeek);
		}
		DayInWeek[] days = DayInWeek.values(); // 1
		for (int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
		DayInWeek oneDay = DayInWeek.valueOf("FRIDAY"); // 2
		System.out.println(oneDay);

		System.out.println("compareTo: " + oneDay.compareTo(DayInWeek.SUNDAY));
		System.out.println("compareTo: " + MobilePhone.IPHONE_8.compareTo(MobilePhone.SAMSUNG_S7));
		System.out.println(oneDay.getDeclaringClass());
		System.out.println(oneDay.name());
		System.out.println(MobilePhone.IPHONE_8.ordinal());
		System.out.println(MobilePhone.SAMSUNG_S7.ordinal());
		System.out.println(MobilePhone.valueOf("SAMSUNG_S9").getPrice());

		MobilePhone phones[] = MobilePhone.values();
		for (int i = 0; i < phones.length; i++) {
			System.out.println(phones[i] + ": " + phones[i].getPrice());
		}
		
	}
}
