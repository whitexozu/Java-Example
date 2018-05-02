package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put("a", "1");
		tmp.put("b", "2");
		
		Map<String, String> sub = new HashMap<String, String>();
		sub.put("c", "3");
		sub.put("b", "4");
		
		
//		tmp.keySet().removeAll(sub.keySet());
		tmp.putAll(sub);
		
		
		for(Entry<String, String> entry : tmp.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println(">>>"+key+":"+value);
		}
		
		List<VO> list = new ArrayList<VO>();
		list.add(new VO("1", "2"));
		list.add(new VO("3", "4"));
		list.add(new VO("4", "4"));
		list.add(new VO("5", "4"));
		list.add(new VO("6", "4"));
		
//		int i = 0;
//		for(VO vo : list) {
		List<Integer> removeIdx = new ArrayList<Integer>();
		for(int i=list.size()-1; i>=0; i--) {
			System.out.println(i);
			VO vo = list.get(i);
			if("3".equals(vo.getS1())) {
				removeIdx.add(i);
			}
			if("5".equals(vo.getS1())) {
				removeIdx.add(i);
			}
		}
		
//		Collections.sort(list);
//		Collections.sort(removeIdx, Collections.reverseOrder()); 
		
		for(int i : removeIdx) {
			list.remove(i);
			System.out.println(">>" + i);
		}
		
		
		for(VO vo : list) {
			System.out.println(vo.getS1() + " : " + vo.getS2());
		}
	}

}

class VO {
	private String s1;
	private String s2;
	public VO(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
}