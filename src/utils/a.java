package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class a {

	public static void main(String[] args) {
		
		for (int grade = 1; grade < 5; grade++) {
			
			ArrayList classes1 = new ArrayList();
			ArrayList classes2 = new ArrayList();
			
			for (int i = 0; i < 10; i++) {
				HashMap hm1 = new HashMap();
				hm1.put("subjnameeng", "subjnameeng" + i);
				hm1.put("hakjum", "hakjum" + i);
				classes1.add(hm1);
			}

			for (int i = 0; i < 8; i++) {
				HashMap hm2 = new HashMap();
				hm2.put("subjnameeng", "subjnameeng" + i);
				hm2.put("hakjum", "hakjum" + i);
				classes2.add(hm2);
			}
			
			int maxClasses = classes1.size() > classes2.size() ? classes1.size() : classes2.size();
			System.out.println("maxClasses : " + maxClasses);
			for ( int i = 0; i < maxClasses;  i++) {
		        HashMap classInfo1 = classes1.size() <= i ? new HashMap() : (HashMap) classes1.get(i);
		        HashMap classInfo2 = classes2.size() <= i ? new HashMap() : (HashMap) classes2.get(i);
		        
//		        System.out.println( classInfo1.get("subjnameeng") == null ? "" : classInfo1.get("subjnameeng") + "|" + classInfo1.get("hakjum") + "|" + classInfo2.get("subjnameeng") + "|" + classInfo2.get("hakjum") );
		        System.out.print( classInfo2.get("subjnameeng") == null ? "b1" : classInfo2.get("subjnameeng") );
		        System.out.println( classInfo2.get("hakjum") == null ? "b2" : classInfo2.get("hakjum") );
			}
		}
	}
}
