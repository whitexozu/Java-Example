package regex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String textDate = "20070722";
		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat nDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat nTime = new SimpleDateFormat("HHmmssSSS");
		
		System.out.println(textDate.substring(0,4));
		System.out.println(textDate.substring(4,6));
		System.out.println(textDate.substring(6,8));
		try {
			java.util.Date date = format.parse(textDate);
			System.out.println(date);
			String sDate = nDate.format(date);
			System.out.println(sDate);
			
			System.out.println(nTime.format(calendar.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
