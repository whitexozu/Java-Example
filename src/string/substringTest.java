package string;

public class substringTest {
	private static StringBuffer valueSb = new StringBuffer();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String vc = "201602011303";
		
		System.out.println(vc.substring(0, 4));
		System.out.println(vc.substring(4, 6));
		System.out.println(vc.substring(6, 8));
		System.out.println(vc.substring(8, 10));
		System.out.println(vc.substring(10, 12));
		
		
		
		
		String tmp = "abc\tdef";
		valueSb.append(tmp);
		System.out.println(valueSb.toString());
		
		System.out.println(tmp.substring(1));
		
		
		String temp = "111_222_333";
		System.out.println(temp.substring(0, temp.lastIndexOf("_")));
		System.out.println(temp.substring(1));
		
		String a = "20160102";
		System.out.println(a.substring(0, 4) + ", " + a.substring(4, 6) + ", " + a.substring(6, 8));
		
	}

}
