package com.app.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	static public Date addNumberOfDaysInDate(int numberOfDays, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, numberOfDays);
		Date dateWithAddedNumberOfDays = calendar.getTime();
		String finalDateStr = dateFormat.format(dateWithAddedNumberOfDays);
		try {
			return dateFormat.parse(finalDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static long getNumberOfDaysBetbeenDates(Date dateBefore, Date dateAfter) {
		LocalDate beforeLocalDate = LocalDate.parse(dateFormat.format(dateBefore));
		LocalDate afterLocalDate = LocalDate.parse(dateFormat.format(dateAfter));
		long noOfDaysBetween = ChronoUnit.DAYS.between(beforeLocalDate, afterLocalDate);
		return noOfDaysBetween;
	}
	

	/*public static void main(String... strings) throws ParseException {
		Date afterDate = addNumberOfDaysInDate(15, new Date());
		long days = getNumberOfDaysBetbeenDates(new Date(), afterDate);
		System.out.println("days -> " + days);
	}*/
}
