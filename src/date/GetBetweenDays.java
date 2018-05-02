package date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetBetweenDays {
	public static void main(String[] args) {
		String sDate = "20180401000000";
		String eDate = "20180416000000";
		List<String> days = new ArrayList<String>();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date d1 = sdf.parse(sDate.substring(0, 8));
			Date d2 = sdf.parse(eDate.substring(0, 8));
			
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
	
			c1.setTime( d1 );
			c2.setTime( d2 );
	
			while( c1.compareTo( c2 ) !=1 ){
				days.add(sdf.format(c1.getTime()));
				c1.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(days);
	}
}
