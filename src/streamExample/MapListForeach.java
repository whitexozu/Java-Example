package streamExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListForeach {
	public static void main(String[] args) {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		items.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E");
			}
		});
		
		
		List<String> lists = new ArrayList<>();
		lists.add("A");
		lists.add("B");
		lists.add("C");
		lists.add("D");
		lists.add("E");

		//lambda
		//Output : A,B,C,D,E
		lists.forEach(item->System.out.println(item));
			
		//Output : C
		lists.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});
			
		//method reference
		//Output : A,B,C,D,E
		lists.forEach(System.out::println);
		
		//Stream and filter
		//Output : B
		lists.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
	}
}
