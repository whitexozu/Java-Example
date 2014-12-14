package string;

public class split {

	/**
	 * summary.
	 * <PRE>
	 * 1. MethodName : main
	 * 2. ClassName  : split
	 * 4. Author     : jhkim-win7
	 * 5. Date       : 2013. 8. 20. ���� 3:30:07
	 * </PRE>
	 *   @return void
	 *   @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "2013-01-02";
		String[] array = temp.split("-");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		
		String temp2 = "shipDateA";
		String no = temp2.substring(temp2.length()-1);
		String before = temp2.substring(0, temp2.length()-1);
		System.out.println(temp2 + " , " + no  + " , " + before);
	}

}
