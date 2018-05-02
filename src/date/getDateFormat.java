package date;

import java.util.Calendar;

public class getDateFormat {
	public static void main(String[] args) {
		System.out.println("YEAR : " + dateDateString("20180206", 0));
		System.out.println("MONTH : " + dateDateString("20180206", 1));
		System.out.println("DAY : " + dateDateString("20180206", 2));
		System.out.println("HOUR : " + dateDateString("2018020610", 3));
		System.out.println("half : " + dateDateString("20180206", 4));
		System.out.println("QUARTER : " + dateDateString("20180206", 5));
		System.out.println("WEEK : " + dateDateString("20180206", 6));
		System.out.println("DAYOFWEEK : " + dateDateString("20180206", 7));
		System.out.println("MONTH : " + dateDateString("20180206", 8));
		System.out.println("DAY : " + dateDateString("20180206", 9));
		System.out.println("HOUR : " + dateDateString("2018020610", 10));
		
		
		System.out.println("WEEK (20180204): " + dateDateString("20180204", 6));
		System.out.println("WEEK (20180205): " + dateDateString("20180205", 6));
		System.out.println("WEEK (20180211): " + dateDateString("20180211", 6));
		System.out.println("WEEK (20180212): " + dateDateString("20180212", 6));
		System.out.println("WEEK (20180228): " + dateDateString("20180228", 6));
		System.out.println("WEEK (20180304): " + dateDateString("20180304", 6));
		System.out.println("WEEK (20180305): " + dateDateString("20180305", 6));
		System.out.println("WEEK (20180311): " + dateDateString("20180311", 6));
		System.out.println("WEEK (20180319): " + dateDateString("20180319", 6));
		System.out.println("WEEK (20180325): " + dateDateString("20180325", 6));
		System.out.println("WEEK (20180326): " + dateDateString("20180326", 6));
		System.out.println("WEEK (20180402): " + dateDateString("20180402", 6));
	}
	public static String dateDateString(String dt, int type) {
		String year = dt.substring(0, 4);
		String month = dt.substring(4, 6);
		String day = dt.substring(6, 8);
		String mnt_Year = null;
		String mnt_Month = null;

		int rtn = 0;

		if (type == 0) { // YEAR
			dt = year;
		} else if (type == 1) { // MONTH
			dt = year + month;
		} else if (type == 2) { // DAY
			dt = year + month + day;
		} else if (type == 3) { // HOUR
			dt = dt.substring(0, 10);
		} else if (type == 4) { // HALF
			rtn = (int) Math.ceil(Integer.parseInt(month) / 6.0);
			dt = year + "0" + rtn;
		} else if (type == 5) { // QUARTER
			rtn = (int) Math.ceil(Integer.parseInt(month) / 3.0);
			dt = year + "0" + rtn;
		} else if (type == 6) { // WEEK
			Calendar SCal = Calendar.getInstance();
			SCal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));

			mnt_Year = year;
			mnt_Month = month;

			int week = 0;
//			SCal.setFirstDayOfWeek(java.util.Calendar.SUNDAY);
			SCal.setFirstDayOfWeek(java.util.Calendar.MONDAY);
			SCal.setMinimalDaysInFirstWeek(7);
			week = SCal.get(java.util.Calendar.WEEK_OF_MONTH);

			if (week == 0) {
				int tmpMonth = Integer.parseInt(month) - 1;
				if (tmpMonth >= 10) {
					mnt_Month = "" + tmpMonth;
				} else {
					if (tmpMonth == 0) {
						mnt_Month = "12";
						mnt_Year = "" + (Integer.parseInt(mnt_Year) - 1);
					} else {
						mnt_Month = "0" + tmpMonth;
					}
				}

				SCal.set(Integer.parseInt(year), Integer.parseInt(month) - 2, Integer.parseInt(day));
				int endDay = SCal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
				SCal.set(Integer.parseInt(year), Integer.parseInt(month) - 2, endDay);
				SCal.setFirstDayOfWeek(java.util.Calendar.SUNDAY);
				SCal.setMinimalDaysInFirstWeek(7);
				week = SCal.get(java.util.Calendar.WEEK_OF_MONTH);
			}
			dt = mnt_Year + mnt_Month + "0" + week;
		} else if (type == 7) { // 요일
			int computation = Integer.parseInt(day) + (26 * (Integer.parseInt(month) + 1)) / 10 + Integer.parseInt(year) + Integer.parseInt(year) / 4 + 6 * (Integer.parseInt(year) / 100) + Integer.parseInt(year) / 400;
			int dayOfWeek = computation % 7;
			switch (dayOfWeek) {// 0~6까지 토~금요일로 표시
			case 0:
				dt = "5";
				break;
			case 1:
				dt = "6";
				break;
			case 2:
				dt = "0";
				break;
			case 3:
				dt = "1";
				break;
			case 4:
				dt = "2";
				break;
			case 5:
				dt = "3";
				break;
			case 6:
				dt = "4";
				break;
			}
		} else if (type == 8) { // MONTH
			dt = month;
		} else if (type == 9) { // DAY
			dt = day;
		} else if (type == 10) { // HOUR
			dt = dt.substring(8, 10);
		}

		return dt;
	}
}
