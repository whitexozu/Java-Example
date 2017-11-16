package cast;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalToString {

	/**
	 * summary.
	 * <PRE>
	 * 1. MethodName : main
	 * 2. ClassName  : DecimalToString
	 * 4. Author     : jhkim-win7
	 * 5. Date       : 2014. 3. 13. ���� 3:34:34
	 * </PRE>
	 *   @return void
	 *   @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// case 1
		DecimalFormat df = new DecimalFormat("0.00#");
		String result = df.format(34.4959);
		System.out.println("result : "+result);
		
		// case 2
		BigDecimal bd = new BigDecimal("10.0001");
		System.out.println(bd.getClass());
		System.out.println(bd.toString());
		
		// case 3
//		String s = "2.6625081511776";
		String s = "0.6625081511776";
		double d = Double.parseDouble(s);
		int i = (int) d;
		System.out.println(i);
	}

}
