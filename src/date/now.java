package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class now {
	// "yyyy.MM.dd G 'at' HH:mm:ss z" 2001.07.04 AD at 12:08:56 PDT
	// "EEE, MMM d, ''yy" Wed, Jul 4, '01
	// "h:mm a" 12:08 PM
	// "hh 'o''clock' a, zzzz" 12 o'clock PM, Pacific Daylight Time
	// "K:mm a, z" 0:08 PM, PDT
	// "yyyyy.MMMMM.dd GGG hh:mm aaa" 02001.July.04 AD 12:08 PM
	// "EEE, d MMM yyyy HH:mm:ss Z" Wed, 4 Jul 2001 12:08:56 -0700
	// "yyMMddHHmmssZ" 010704120856-0700
	// "yyyy-MM-dd'T'HH:mm:ss.SSSZ" 2001-07-04T12:08:56.235-0700

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTodayString());
		System.out.println(getNowString());
		System.out.println(getDateString("yyMMdd"));
		System.out.println(getDateString("hhmm"));

		System.out.println(getDay(0, "yyyyMMdd"));
		System.out.println(getDay(-1, "yyyy-MM-dd"));
	}

	public static String getTodayString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
		return format.format(new Date());
	}

	public static String getNowString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmSS", Locale.getDefault());
		return format.format(new Date());
	}

	public static String getDateString(String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat, Locale.getDefault());
		return format.format(new Date());
	}

	public static String getDay(int i, String fm) {
		GregorianCalendar todayCal = new GregorianCalendar();
		if (i != 0)
			todayCal.add(todayCal.DATE, i);
		String yDate = format(todayCal, fm);
		// String yDate = String.valueOf(todayCal.get(Calendar.YEAR)) + "-" +
		// String.valueOf(todayCal.get(Calendar.MONTH) + 1) + "-" +
		// String.valueOf(todayCal.get(Calendar.DAY_OF_MONTH));
		return yDate;
	}

	public static String format(GregorianCalendar calendar, String fm) {
		SimpleDateFormat fmt = new SimpleDateFormat(fm);
		fmt.setCalendar(calendar);
		String dateFormatted = fmt.format(calendar.getTime());
		return dateFormatted;
	}

}
