package date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeekOfMonth {
	public static void main(String[] args) {
//		getWeekInMonths("2017", "2");
//		getWeekInYears("2017");
//		getInternalInfoMonthQuery("2016");
//		getInternalInfoYearQuery("2015");
		
//		getVocEventInfoMonthQuery("2016");
		getVocEventInfoYearQuery("2015");
		
//		getVocEventInfoMonthQuery2("2016");
//		getVocEventInfoYearQuery2("2016");
	}
	
	public static void getVocEventInfoYearQuery2(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.YEAR, intYear);
		
		for (int qtr = 0; qtr < 4; qtr++) {
			sb.append("INSERT INTO VOCEVENTINFO_YEAR_ORC PARTITION (YEAR='"+year+"') ");
			sb.append("SELECT '"+year+String.format("%02d", qtr+1)+"' AS REGDATE, CHANNEL, VOC_CAT_ID, PRODUCT_CAT_ID, SENSE, SUM(CNT) AS CNT "); 
			sb.append("FROM VOCEVENTINFO_DAY_ORC WHERE ");
			
			int m = qtr * 3;
			for (int month = m; month < m + 3; month++) {
				
				sb.append("(YEAR = "+year+" AND MONTH = "+String.format("%02d", month+1)+")");
				if( month != m + 2 ) {
					sb.append(" OR ");
				}
			}
			sb.append(" GROUP BY CHANNEL, VOC_CAT_ID, PRODUCT_CAT_ID, SENSE;");
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	public static void getVocEventInfoMonthQuery2(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.YEAR, intYear);
		for (int month = 1; month <= 9; month++) {
			cal.set(Calendar.MONTH, month - 1);
			
			int realWeek = 0;
			
			cal.set(Calendar.DATE, 1);
			int firstDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			int lastDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			int sw = firstDateOfWeek > 4 ? 1 : 0;
			int lw = lastDateOfWeek < 4 ? 0 : 1;
			int wom = cal.get(Calendar.WEEK_OF_MONTH);
			
			for (int week = 1 + sw; week < wom + lw; week++) {
				realWeek++;
				sb.append("INSERT INTO VocEventInfo_month_orc"); 
				sb.append(" PARTITION (YEAR='"+year+"',MONTH='"+String.format("%02d", month)+"')"); 
				sb.append(" SELECT '" + year + String.format("%02d", month) + String.format("%02d", realWeek) + "' AS REGDATE, CHANNEL, VOC_CAT_ID, PRODUCT_CAT_ID, SENSE, SUM(CNT) AS CNT FROM VOCEVENTINFO_DAY_ORC WHERE ");
				
				cal.set(Calendar.WEEK_OF_MONTH, week);
				
				List<String> list = new ArrayList<String>();
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
	
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
	
				for (int s = 0; s < list.size(); s++) {
					sb.append("(YEAR = "+year+" AND MONTH = "+String.format("%02d", month)+" AND DAY="+String.format("%02d", Integer.parseInt(list.get(s)))+")");
					if( s != list.size() - 1 ) {
						sb.append(" OR ");
					}
				}
				sb.append(" GROUP BY CHANNEL, VOC_CAT_ID, PRODUCT_CAT_ID, SENSE;");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		}
	}
	
	public static void getVocEventInfoYearQuery(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.YEAR, intYear);
		
		for (int qtr = 0; qtr < 4; qtr++) {
			sb.append("INSERT INTO VOCEVENTINFO_YEAR_ORC PARTITION (YEAR='"+year+"') ");
			sb.append("SELECT '"+year+String.format("%02d", qtr+1)+"' AS REGDATE, CHANNEL, VOC_CAT_ID, EVENT_DETAIL_CODE, SUM(CNT) AS CNT "); 
			sb.append("FROM VOCEVENTINFO_DAY_ORC WHERE ");
			
			int m = qtr * 3;
			for (int month = m; month < m + 3; month++) {
				
				sb.append("(YEAR = "+year+" AND MONTH = "+String.format("%02d", month+1)+")");
				if( month != m + 2 ) {
					sb.append(" OR ");
				}
			}
			sb.append(" GROUP BY CHANNEL, VOC_CAT_ID, EVENT_DETAIL_CODE;");
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	public static void getVocEventInfoMonthQuery(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.YEAR, intYear);
		for (int month = 1; month <= 9; month++) {
			cal.set(Calendar.MONTH, month - 1);
			
			int realWeek = 0;
			
			cal.set(Calendar.DATE, 1);
			int firstDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			int lastDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			int sw = firstDateOfWeek > 4 ? 1 : 0;
			int lw = lastDateOfWeek < 4 ? 0 : 1;
			int wom = cal.get(Calendar.WEEK_OF_MONTH);
			
			for (int week = 1 + sw; week < wom + lw; week++) {
				realWeek++;
				sb.append("INSERT INTO VocEventInfo_month_orc"); 
				sb.append(" PARTITION (YEAR='"+year+"',MONTH='"+String.format("%02d", month)+"')"); 
				sb.append(" SELECT '" + year + String.format("%02d", month) + String.format("%02d", realWeek) + "' AS REGDATE, CHANNEL, VOC_CAT_ID, EVENT_DETAIL_CODE, SUM(CNT) AS CNT FROM VOCEVENTINFO_DAY_ORC WHERE ");
				
				cal.set(Calendar.WEEK_OF_MONTH, week);
				
				List<String> list = new ArrayList<String>();
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
	
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
	
				for (int s = 0; s < list.size(); s++) {
					sb.append("(YEAR = "+year+" AND MONTH = "+String.format("%02d", month)+" AND DAY="+String.format("%02d", Integer.parseInt(list.get(s)))+")");
					if( s != list.size() - 1 ) {
						sb.append(" OR ");
					}
				}
				sb.append(" GROUP BY CHANNEL, VOC_CAT_ID, EVENT_DETAIL_CODE;");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		}
	}
	
	public static void getInternalInfoYearQuery(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.YEAR, intYear);
		
		for (int qtr = 0; qtr < 4; qtr++) {
			sb.append("INSERT INTO InternalData_year_orc PARTITION (YEAR='"+year+"') ");
			sb.append("SELECT '"+year+String.format("%02d", qtr+1)+"' AS REGDATE, PRODUCT_CAT_ID, VOC_CAT_ID, CHANNEL, SUM(PROD1_COUNT) AS PROD1_COUNT, SUM(PROD2_COUNT) AS PROD2_COUNT, SUM(CNT) AS CNT "); 
			sb.append("FROM InternalData_day_orc WHERE ");
			
			int m = qtr * 3;
			for (int month = m; month < m + 3; month++) {
				
				sb.append("(YEAR = "+year+" AND MONTH = "+String.format("%02d", month+1)+")");
				if( month != m + 2 ) {
					sb.append(" OR ");
				}
			}
			sb.append(" GROUP BY PRODUCT_CAT_ID, VOC_CAT_ID, CHANNEL;");
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	public static void getInternalInfoMonthQuery(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		
		StringBuffer sb = new StringBuffer();
		
		cal.set(Calendar.YEAR, intYear);
		for (int month = 2; month <= 8; month++) {
			cal.set(Calendar.MONTH, month - 1);
			
			int realWeek = 0;
			
			cal.set(Calendar.DATE, 1);
			int firstDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			int lastDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			int sw = firstDateOfWeek > 4 ? 1 : 0;
			int lw = lastDateOfWeek < 4 ? 0 : 1;
			int wom = cal.get(Calendar.WEEK_OF_MONTH);
			
			for (int week = 1 + sw; week < wom + lw; week++) {
				realWeek++;
				sb.append("INSERT INTO InternalData_month_orc"); 
				sb.append(" PARTITION (YEAR='"+year+"',MONTH='"+String.format("%02d", month)+"')"); 
				sb.append(" SELECT '" + year + String.format("%02d", month) + String.format("%02d", realWeek) + "' AS REGDATE, PRODUCT_CAT_ID, VOC_CAT_ID, CHANNEL, SUM(PROD1_COUNT) AS PROD1_COUNT, SUM(PROD2_COUNT) AS PROD2_COUNT, SUM(CNT) AS CNT FROM INTERNALDATA_DAY_ORC WHERE ");
				
				cal.set(Calendar.WEEK_OF_MONTH, week);
				
				List<String> list = new ArrayList<String>();
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
	
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				list.add(String.format("%02d", (cal.get(Calendar.DAY_OF_MONTH))));
	
				for (int s = 0; s < list.size(); s++) {
					sb.append("(YEAR = "+year+" AND MONTH = "+String.format("%02d", month)+" AND DAY="+String.format("%02d", Integer.parseInt(list.get(s)))+")");
					if( s != list.size() - 1 ) {
						sb.append(" OR ");
					}
				}
				sb.append(" GROUP BY PRODUCT_CAT_ID, VOC_CAT_ID, CHANNEL;");
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		}
	}
	
	public static void getWeekInYears(String year) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);

		cal.set(Calendar.YEAR, intYear);
		for (int month = 1; month <= 12; month++) {
			cal.set(Calendar.MONTH, month - 1);
			
			int realWeek = 0;
			
			cal.set(Calendar.DATE, 1);
			int firstDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			int lastDateOfWeek =  cal.get(Calendar.DAY_OF_WEEK);
			
			int sw = firstDateOfWeek > 4 ? 1 : 0;
			int lw = lastDateOfWeek < 4 ? 0 : 1;
			int wom = cal.get(Calendar.WEEK_OF_MONTH);
//			System.out.println(firstDateOfWeek + " : " + lastDateOfWeek + " : " + sw + " : " + lw);
			for (int week = 1 + sw; week < wom + lw; week++) {
				realWeek++;
				
				cal.set(Calendar.WEEK_OF_MONTH, week);
				
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
				int startDay = cal.get(Calendar.DAY_OF_MONTH);
	
				cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				int endDay = cal.get(Calendar.DAY_OF_MONTH);
	
				System.out.println(intYear + "년 " + month + "월 " + realWeek + "주 : " + startDay + " ~ " + endDay);
				
			}
		}
	}

	public static void getWeekInMonths(String year, String month) {
		Calendar cal = Calendar.getInstance();
		int intYear = Integer.parseInt(year);
		int intMonth = Integer.parseInt(month);

		cal.set(Calendar.YEAR, intYear);
		cal.set(Calendar.MONTH, intMonth - 1);
		
		for (int week = 1; week < cal.getMaximum(Calendar.WEEK_OF_MONTH); week++) {
			cal.set(Calendar.WEEK_OF_MONTH, week);

			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			int startDay = cal.get(Calendar.DAY_OF_MONTH);

			cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			int endDay = cal.get(Calendar.DAY_OF_MONTH);

//			if (week == 1 && startDay >= 7) {
//				startDay = 1;
//			}

//			if (week == cal.getMaximum(Calendar.WEEK_OF_MONTH) - 1 && endDay <= 7) {
//				endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//			}

			System.out.println(week + "주 : " + startDay + " ~ " + endDay);
		}
	}
}