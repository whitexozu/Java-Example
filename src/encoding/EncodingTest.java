package encoding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EncodingTest {
	static String convert(String str, String encoding) throws IOException {
		ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();
		requestOutputStream.write(str.getBytes(encoding));
		return requestOutputStream.toString(encoding);
	}

	static String testEncoding(String str, String encoding) throws IOException {
		String result = convert(str, encoding);
		System.out.println(result + "=>encoding=" + encoding + ",length=(" + result.getBytes(encoding).length + ")");
		return result;
	}

	public static void main(String args[]) throws Exception {
		System.out.println("==== file.encoding===" + System.getProperty("file.encoding"));
		String aa = "한글테스트";
		testEncoding(aa, "MS949");
		testEncoding(aa, "UTF-8");
		testEncoding(aa, "CP933");
		testEncoding(aa, "EUC-KR");
	}
}
