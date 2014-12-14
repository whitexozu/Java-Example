package string;

public class substring {

	/**
	 * summary.
	 * <PRE>
	 * 1. MethodName : main
	 * 2. ClassName  : split
	 * 4. Author     : jhkim-win7
	 * 5. Date       : 2013. 8. 20. 오후 3:30:07
	 * </PRE>
	 *   @return void
	 *   @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "한글.jpg";
		System.out.println(temp.substring(0, temp.lastIndexOf(".")));
		System.out.println(temp.substring(temp.lastIndexOf(".")));
	}

}
