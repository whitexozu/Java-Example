package date;

import java.time.LocalDate;

public class JodaTime {
	public static void main(String[] args) {
//		LocalDate startDate = LocalDate.of(2011, 11, 8);
//		LocalDate endDate = LocalDate.of(2012, 5, 1);
	
//		startDate = startDate.withDayOfMonth(1);
	
//		while (!startDate.isAfter(endDate)) {
//		    System.out.println("> " + startDate);
//		    startDate = startDate.plusMonths(1);
//		    LocalDate endOfMonth = startDate.minusDays(1);
//		    System.out.println("< " + endOfMonth);
//		}
		
		LocalDate nDate = LocalDate.now();
		int nYear = nDate.getYear();
		int nMonth = nDate.getMonthValue();
		int nDay = nDate.getDayOfMonth();
		
		System.out.println("today :  " + nDate.getYear() + ", " + nDate.getMonthValue() + ", " + nDate.getDayOfMonth());
		LocalDate sDate = LocalDate.of(nYear - 1, nMonth, nDay);
		LocalDate eDate = LocalDate.of(nYear, nMonth, nDay);
		
//		sDate = eDate.minusDays(1);
		System.out.println("sdate :  " + sDate);
		
		while (!sDate.isAfter(eDate)) {
		    System.out.println("> " + sDate);
		    sDate = sDate.plusDays(1);
//		    LocalDate endOfMonth = startDate.minusDays(1);
//		    System.out.println("< " + endOfMonth);
		}
	}
}
