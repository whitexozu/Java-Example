package encoding;

import java.io.UnsupportedEncodingException;

public class CharSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharSet cs = new CharSet();
		try {
			cs.charSet("한글테스트");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void charSet(String str_kr) throws UnsupportedEncodingException {
		String charset[] = { "euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii", "UTF-8" };

		for (int i = 0; i < charset.length; i++) {
			for (int j = 0; j < charset.length; j++) {
				if (i == j)
					continue;

				System.out.println(
						charset[i] + " : " + charset[j] + " :" + new String(str_kr.getBytes(charset[i]), charset[j]));
			}
		}
	}
}
