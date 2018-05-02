package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class month {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String thisMonth = "20171001";
		String year = thisMonth.substring(0, 4);
		String month = thisMonth.substring(4, 6);

		int _year = Integer.parseInt(year);
		int _month = Integer.parseInt(month);

		Calendar cal = Calendar.getInstance();
		cal.set(_year, (_month - 2), 1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");

		String beforeYear = dateFormat.format(cal.getTime()).substring(0, 4);
		String beforeMonth = dateFormat.format(cal.getTime()).substring(4, 6);

		String retStr = beforeYear + beforeMonth;
		System.out.println("retStr : " + retStr);

	}

}
