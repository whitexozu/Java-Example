package string;

public class compare {
	public static void main(String[] args) {
		System.out.println("01064325274".length());
		String now = "20180212112233";
		String last = "20180212112231";
		String temp = "20180212112232";
		System.out.println(now.compareTo(temp));
		System.out.println(last.compareTo(temp));
		
		
		System.out.println("20180410030000".compareTo("20180409050000"));
    }
}
