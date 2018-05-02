package regex;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class date {

	public static void main(String[] args) {
//		String textDate = "20070722";
//		Calendar calendar = Calendar.getInstance();
//
//		SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");
//		SimpleDateFormat nDate = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat nTime = new SimpleDateFormat("HHmmssSSS");
//		
//		System.out.println(textDate.substring(0,4));
//		System.out.println(textDate.substring(4,6));
//		System.out.println(textDate.substring(6,8));
//		try {
//			Date date = format.parse(textDate);
//			System.out.println(date);
//			String sDate = nDate.format(date);
//			System.out.println(sDate);
//			
//			System.out.println(nTime.format(calendar.getTime()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		try {
			
			String temp = "20180205100000";
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 ddHHmmss");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 ddHHmmss");
			Date currDate = null;
			currDate = sdf.parse(temp);
			String nowTimeStamp = sdf.format(currDate);
			System.out.println(nowTimeStamp);
			
//			Date date = cal.getTime();
//			SimpleDateFormat format = new SimpleDateFormat(formatType);
//			String returnDate = format.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		


	}

}
