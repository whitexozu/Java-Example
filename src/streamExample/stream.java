package streamExample;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class stream {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		// List<String> lines = Arrays.asList("spring", "node", "mkyong");
		//
		// List<String> result = lines.stream() // convert list to stream
		// .filter(line -> !"mkyong".equals(line)) // we dont like mkyong
		// .collect(Collectors.toList()); // collect the output and convert streams to a List
		//
		// result.forEach(System.out::println); // output : spring, node

		
//		IntStream.range(0, 10).parallel().forEach(index -> {
//			System.out.println("Starting " + Thread.currentThread().getName() + ",    index=" + index + ", " + new Date());
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//			}
//		});
	
		ForkJoinPool myPool = new ForkJoinPool(5);
		myPool.submit(() -> {
			IntStream.range(0, 10).parallel().forEach(index -> {
				System.out.println("Starting " + Thread.currentThread().getName() + ", index=" + index + ", " + new Date());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			});
		}).get();
	}
}
