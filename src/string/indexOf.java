package string;

public class indexOf {
	public static void main(String[] args) {
//		String temp1 = "abcd_1234";
		String temp1 = "abcd";
		
		System.out.println( temp1.substring(0, temp1.indexOf("_") > -1 ? temp1.indexOf("_") : temp1.length()) );
	}
}
