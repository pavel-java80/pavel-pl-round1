package com.jp.morgan.interview.utils;

// Created by pavel.plakhotnik on 2017-11-06.

import java.time.LocalDate;

/**
 *
 */
public class DateUtils {
	public static void assertWorkingDay(LocalDate date) {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null");
		}
		switch (date.getDayOfWeek()) {
			case SATURDAY:
				throw new IllegalArgumentException("the given day is Saturday. Day off.");
			case SUNDAY:
				throw new IllegalArgumentException("the given day is Sunday. Day off.");
		}
		//here we can add another day off processing (New Year, Easter, etc.)
	}
}
