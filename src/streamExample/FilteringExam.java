package streamExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringExam {
	public static void main(String[] args) {
//		List<String> names = Arrays.asList("Jack Daniel", "Andy Smith", "Demian Rice", "Mike Tomson", "Jack Daniel", "Jolie Martonne"
//
//		);
//
//		names.stream().distinct().forEach(n -> System.out.println(n));
//		System.out.println();
//
//		names.stream().filter(n -> !n.startsWith("J")).forEach(n -> System.out.println(n));
//		System.out.println();
//
//		names.stream().distinct().filter(n -> n.startsWith("J")).forEach(n -> System.out.println(n));
		
		String s = "2", e = "5";
		List<String> ids = Arrays.asList("1", "3", "4", "", "7", "8");
		List<String> arr = new ArrayList<String>(); 
		ids.stream()
			.filter(id -> {
				if ( e.compareTo(id) > 0 && s.compareTo(id) < 0 && !"".equals(id) ) {
					return true;
				} else {
					return false;
				}
			})
			.forEach(id -> {
				arr.add(id);
			});
		
		for(String st : arr) {
			System.out.println(st);
		}
	}

}
