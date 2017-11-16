package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class millisecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		for(int i=0; i<100; i++) {
//			String strDT = sf.format(new Date(System.currentTimeMillis()));
//			System.out.println(strDT);
//		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
//		System.out.println(sf.format(new Date(System.currentTimeMillis())));
//		System.out.println(Long.toString(System.currentTimeMillis()));
//		
//		for(int i=0; i<100; i++) {
//			System.out.println(Long.toString(System.currentTimeMillis()));
//		}
		
		
		long temp = System.currentTimeMillis();
		System.out.println(Long.toString(temp));
		System.out.println(sf.format(new Date(temp)));
		for(int i=0; i<100; i++) {
			System.out.println(Long.toString(temp));
		}
	}
}
