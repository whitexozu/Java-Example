package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class localDate {

	public static void main(String[] args) {
		String parmDateToNow = "20180323";
		int tempYear = Integer.parseInt(parmDateToNow.substring(0, 4));
		int tempMonth = Integer.parseInt(parmDateToNow.substring(4, 6));
		int tempDay = Integer.parseInt(parmDateToNow.substring(6, 8));
		LocalDate localDate = LocalDate.of(tempYear, tempMonth, tempDay).minusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(localDate);
		System.out.println(localDate.format(formatter));
	}

}
