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
	}
	
	public static String getRPad(String str, int size, String strFillText) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str += strFillText;
        }
        return str;
    }

}
