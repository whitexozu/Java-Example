package math;

import java.util.stream.IntStream;

public class divide {

	public static void main(String[] args) {
		Double max = 23.0;
		Double div = max/3;
//		Double group = 0.0;
		System.out.println(div);
		IntStream.range(1,  max.intValue() + 1).forEach(i -> {
			Double group = Math.ceil(i / div);
			System.out.println(i + ", " + group);
		});
	}
}
