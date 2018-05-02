package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.poi.util.SystemOutLogger;

public class ForkJoinTest {
	static class ForkJoinSumTask extends RecursiveTask<Integer> {
		static final int SPLIT_THRESHOLD = 10;
		int[] values;
		int startPos;
		int endPos;

		public ForkJoinSumTask(int[] values) {
			this(values, 0, values.length);
		}

		public ForkJoinSumTask(int[] values, int startPos, int endPos) {
			this.values = values;
			this.startPos = startPos;
			this.endPos = endPos;
		}

		@Override
		protected Integer compute() {
			int computeTargetValueLength = endPos - startPos;
			if (computeTargetValueLength <= SPLIT_THRESHOLD) {
				return sumValuesSequentially();
			}
			int splitPosition = startPos + computeTargetValueLength / 2;
			ForkJoinSumTask left = new ForkJoinSumTask(values, startPos, splitPosition);
			left.fork();

			ForkJoinSumTask right = new ForkJoinSumTask(values, splitPosition, endPos);

			int rightTaskResult = right.compute();
			int leftTaskResult = left.join();

			return leftTaskResult + rightTaskResult;
		}

		private int sumValuesSequentially() {
			int sum = Arrays.stream(values, startPos, endPos).reduce(0, (a, b) -> a + b);
			System.out.println(Thread.currentThread().getName() + ", startPos=" + startPos + ", endPos=" + endPos + ", sum=" + sum);
			return sum;
		}
	}
	
	public static List<String> createRandomList(int listSize) {
		List<String> sourceWords = new ArrayList<String>();
		sourceWords.add("aaa");
		sourceWords.add("bbb");
		sourceWords.add("ccc");
		
		Random rand = new Random();
		List<String> wordList = rand
				.ints(listSize, 0, sourceWords.size())
				.mapToObj(i -> sourceWords.get(i))
				.collect(Collectors.toList());

		return wordList;
	}

	public static void main(String[] args) throws Exception {
		long startTime = System.nanoTime();

		IntStream nums = IntStream.rangeClosed(0, 10000);
		List<String> rlist = createRandomList(50001);
		
		List<String> fileList = new ArrayList<String>();
		List<String> meta = new ArrayList<String>();
		List<String> sentence = new ArrayList<String>();
		List<Map<String, String>> resultList1 = new ArrayList<Map<String, String>>();
		List<Map<String, String>> resultList2 = new ArrayList<Map<String, String>>();
		
		nums.forEach(i -> {
			String key = Integer.toString(i);
			fileList.add(key);
			meta.add(key + "_" + rlist.get(i));
			sentence.add(key + "_" + rlist.get(i));
		});
//		fileList.forEach(s -> System.out.println(s));
		long endTime = System.nanoTime();
		System.out.println("TIME : " + (endTime - startTime) / 1000000.0 + "(ms)");

//		startTime = System.nanoTime();
//		for (String index : fileList) {
//			Map<String, String> temp = new HashMap<String, String>();
//			temp.put("key", index);
//			
//			for ( String s : meta ) {
//				String[] arr = s.split("_");
//				if( index.equals(arr[0]) ) {
//					temp.put("meta", arr[1]);
//				}
//			}
//			
//			for ( String s : sentence ) {
//				String[] arr = s.split("_");
//				if( index.equals(arr[0]) ) {
//					temp.put("sentence", arr[1]);
//				}
//			}
//			
//			resultList1.add(temp);
//		}
//		endTime = System.nanoTime();
//		System.out.println("TIME : " + (endTime - startTime) / 1000000.0 + "(ms)");
//		System.out.println("resultList1 : " + resultList1.size());
		
	
		startTime = System.nanoTime();
		ForkJoinPool forkjoinPool = new ForkJoinPool(10);
		forkjoinPool.submit(() -> {
			fileList.parallelStream().forEach(index -> {
				try {
					Map<String, String> temp = new HashMap<String, String>();
					temp.put("key", index);
					
					for ( String s : meta ) {
						String[] arr = s.split("_");
						if( index.equals(arr[0]) ) {
							temp.put("meta", arr[1]);
						}
					}
					
					for ( String s : sentence ) {
						String[] arr = s.split("_");
						if( index.equals(arr[0]) ) {
							temp.put("sentence", arr[1]);
						}
					}
					
					resultList2.add(temp);
//					System.out.println(index);
//					System.out.println("Thread : " + Thread.currentThread().getName() + ", index : " + index + ", date : " + new Date());
//					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}).get();
		endTime = System.nanoTime();
		System.out.println("TIME : " + (endTime - startTime) / 1000000.0 + "(ms)");
		System.out.println("resultList2 : " + resultList2.size());
		
		
		
//		ForkJoinPool forkJoinPool = new ForkJoinPool(20);
//		forkJoinPool.submit(() ->
//		    IntStream.range(1, 1_000_000).parallel().forEach(System.out::println)
//		).get();
		
		
//		List dealmaxList = new ArrayList<String>();
//		ForkJoinPool forkjoinPool = new ForkJoinPool(5);
//		forkjoinPool.submit(() -> {
//			dealmaxList.parallelStream().forEach(index -> {
//				System.out.println("Thread : " + Thread.currentThread().getName() + ", index : " + index + ", date : " + new Date());
//				try{
//					Thread.sleep(5000);
//				} catch (InterruptedException e){
//				}
//			});
//		}).get();
		
		
//		int[] values = IntStream.rangeClosed(1, 80).toArray();
//		Arrays.stream(values).forEach(i -> System.out.println(i));
//		ForkJoinTask<Integer> task = new ForkJoinSumTask(values);
//		int totalSum = new ForkJoinPool().commonPool().invoke(task);
//		System.out.println("Total sum: " + totalSum);
	}
}
