package streamExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapExam {
	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList("java8 lamda", "Stream mapping");
		inputList1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(word -> System.out.println(word));

		System.out.println();

		List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
		inputList2.stream().flatMapToInt(data -> {
			String[] strArr = data.split(",");
			int[] intArr = new int[strArr.length];

			for (int i = 0; i < strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			System.out.println("=====");
			return Arrays.stream(intArr);
		}).forEach(number -> {
			System.out.println(number);
			System.out.println("------");
		});
	}
	
	//http://palpit.tistory.com/649
}
