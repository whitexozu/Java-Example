package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class millisecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		// for(int i=0; i<100; i++) {
		// String strDT = sf.format(new Date(System.currentTimeMillis()));
		// System.out.println(strDT);
		// }

		
		Date oldDate = new Date();
		Calendar gcal = new GregorianCalendar();
		gcal.setTime(oldDate);
		gcal.add(Calendar.SECOND, -4468);
		Date newDate = gcal.getTime();
		System.out.println(sf.format(oldDate));
		System.out.println(sf.format(newDate));
	}
}
