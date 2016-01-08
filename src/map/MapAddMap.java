package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapAddMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put("a", "1");
		tmp.put("b", "2");
		tmp.put("c", "3");
		tmp.put("e", "4");
		
		Map<String, String> sub = new HashMap<String, String>();
		sub.put("c", "3");
		sub.put("d", "4");
		
		
		tmp.keySet().removeAll(sub.keySet());
		
		
		for(Entry<String, String> entry : tmp.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println(">>> "+key+":"+value);
		}
	}

}
