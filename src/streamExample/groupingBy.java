package streamExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class groupingBy {
	public static void main(String[] args) throws FileNotFoundException, IOException {

//		// 3 apple, 2 banana, others 1
//		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
//
//		Map<String, Long> result = items.stream().collect(
//				Collectors.groupingBy(
//						Function.identity(), Collectors.counting()
//				)
//		);
//
//		Map<String, Long> finalMap = new LinkedHashMap<>();
//		
//		result.entrySet().stream().forEach(m -> {
//			System.out.println(m.getKey()+ ", " + m.getValue());
//		});
//		
//		// Sort a map and add to finalMap
//		result.entrySet().stream()
//			.sorted(Map.Entry.<String, Long> comparingByValue()
//					.reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
//
//		System.out.println(finalMap);
		
		
		// --------------------------------------------------------------------------------------------------------------------------------------------------
//		Function<String, Character> firstChar =  s -> Character.toLowerCase(s.charAt(0));
//
//		List<String> a = Arrays.asList("foo", "Abc", "bar", "baz", "aBc");
//		
//		Map<Character, List<String>> collect = a.stream()
//		        .collect(Collectors.groupingBy(firstChar));
//
//		System.out.println(collect);
		
		// --------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		Pattern pattern = Pattern.compile(",");
		Pattern pattern2 = Pattern.compile("\\|");
//		try (BufferedReader in = new BufferedReader(new FileReader("/fshome/caf000/dev/eclipse_workspace/javaExample/src/streamExample/test.csv"));) {
//			List<String> players = in.lines().skip(1).map(line -> {
//				String[] arr = pattern.split(line);
//				return Integer.parseInt(arr[0]) + "|" + arr[1] + "|" + arr[2] + "|" + arr[3] + "|" + Integer.parseInt(arr[4]);
//			}).collect(Collectors.toList());
//			
//			System.out.println(players);
//		}
		
//		try {
//			BufferedReader in = new BufferedReader(new FileReader("/fshome/caf000/dev/eclipse_workspace/javaExample/src/streamExample/test.csv"));
//			List<String> players = in.lines().skip(1).map(line -> {
//				String[] arr = pattern.split(line);
//				return Integer.parseInt(arr[0]) + "|" + arr[1] + "|" + arr[2] + "|" + arr[3] + "|" + Integer.parseInt(arr[4]);
//			}).collect(Collectors.toList());
//			
//			System.out.println(players);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			
//		}
		
//		try (BufferedReader in = new BufferedReader(new FileReader("/fshome/caf000/dev/eclipse_workspace/javaExample/src/streamExample/test.csv"));) {
//			Map<List<String>, List<String>> grouped = in.lines().skip(1).map(line -> {
//				String[] arr = pattern.split(line);
//				return Integer.parseInt(arr[0]) + "|" + arr[1] + "|" + arr[2] + "|" + arr[3] + "|" + Integer.parseInt(arr[4]);
//			}).collect(Collectors.groupingBy(x -> {
//				String[] arr = pattern2.split(x);
//				return new ArrayList<String>(Arrays.asList(arr[0], arr[1]));
//			}));
//			
//			System.out.println(grouped);
//		}
		
		
		// --------------------------------------------------------------------------------------------------------------------------------------------------
		
		try (BufferedReader in = new BufferedReader(new FileReader("/fshome/caf000/dev/eclipse_workspace/javaExample/src/streamExample/test.csv"));) {
			Map<List<String>, List<String>> grouped = in.lines().skip(1).map(line -> {
				String[] arr = pattern.split(line);
				return Integer.parseInt(arr[0]) + "|" + arr[1] + "|" + arr[2] + "|" + arr[3] + "|" + Integer.parseInt(arr[4]);
			}).collect(Collectors.groupingBy(x -> {
				String[] arr = pattern2.split(x);
				return new ArrayList<String>(Arrays.asList(arr[0], arr[1]));
			}));
			
			System.out.println(grouped);
		}
		
		
	}
}
