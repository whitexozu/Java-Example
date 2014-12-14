package encryption;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class encoding {

	/**
	 * summary.
	 * <PRE>
	 * 1. MethodName : main
	 * 2. ClassName  : encoding
	 * 4. Author     : jhkim-win7
	 * 5. Date       : 2014. 1. 6. 오후 3:28:03
	 * </PRE>
	 *   @return void
	 *   @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String euckr = "가나다";  // EUC-KR
		String utf8 = null;
		
		try {
			String e = URLEncoder.encode("가나다.jpg", "UTF-8");
			String d = URLDecoder.decode(e, "UTF-8");
			System.out.println(e);
			System.out.println(d);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		try {
			utf8 = new String(euckr.getBytes("euc-kr"), "utf-8");
			System.out.println("utf8 : "+utf8);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
