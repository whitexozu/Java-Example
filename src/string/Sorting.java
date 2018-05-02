package string;

import java.util.Arrays;
import java.util.List;

public class Sorting {
	public static void main(String[] args) {
		String[] a = {"20180203", "20180207", "20180205" ,"20180206", "20180201"};
		Arrays.sort(a, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(a));
		
		

		List<String> cities = Arrays.asList("20180203", "20180207", "20180205" ,"20180206", "20180201");
		System.out.println(cities);
//	[Milan, london, San Francisco, Tokyo, New Delhi]
		cities.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(cities);
	}
}
