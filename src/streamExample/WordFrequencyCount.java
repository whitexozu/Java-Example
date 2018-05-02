package streamExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import au.com.bytecode.opencsv.CSVWriter;

public class WordFrequencyCount {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Pattern pattern1 = Pattern.compile(";");
		Pattern pattern2 = Pattern.compile("\\|");
		
//		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		List<String> items = new ArrayList<String>();
		
		try (BufferedReader in = new BufferedReader(new FileReader("/fshome/caf000/ta/seoul/csv/20180214/analyze/analyze_20180214_002.csv"));) {
			in.lines().forEach(line -> {
				String[] arr = pattern2.split(line);
				if(arr.length == 13) {
//					System.out.println(arr.length + " : " + Arrays.toString(arr));
					String[] ks = pattern1.split(arr[12]);
					for(String s : ks) {
						items.add(s);	
					}
				}
			});
		}
//		System.out.println(items.size());
		
//		for(String s : items) {
//			System.out.println(">>>" + s);
//		}
		
//		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/fshome/caf000/ta/seoul/csv/20180214/analyze/word_frequency.log"), "UTF-8"));
		Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		result.entrySet().forEach(m -> {
			try {
				out.write(m.getKey() + "\t" + String.valueOf(m.getValue()) + "\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		out.close();

//		CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream("/fshome/caf000/ta/seoul/csv/20180214/analyze/word_frequency_count.log", true), "UTF-8"), '\t', '\0');
//		Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		result.entrySet().forEach(m -> {
//			System.out.println(m.getKey() + " : " + m.getValue());
//			cw.writeNext(new String[]{m.getKey(), String.valueOf(m.getValue())});
//		});
//		cw.close();
	}
}
