package string;


public class format {

	public static void main(String[] args) {
		int serial = 3;
		String temp = "A";
		String num = "4";
		
		String test = String.format("%03d", serial); 
		System.out.println(test);
		
		test = String.format("% "+num+"d", serial); 
		System.out.println(test);
		
		test = getRPad("AAA", 8, " "); 
		System.out.println("'"+test+"'");
		
		String str1 = "검색결뮻abdaef과 약 5,280개 (0.02)초";
        String clean1 = str1.replaceAll("[^0-9]", "");
        System.out.println(clean1);
	}
	
	public static String getRPad(String str, int size, String strFillText) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str += strFillText;
        }
        return str;
        
        
    }

}
