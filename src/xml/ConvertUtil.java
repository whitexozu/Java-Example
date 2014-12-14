package xml;

import java.nio.CharBuffer;

public class ConvertUtil {
	public static String toXMLString(String input) {
		String xmlString = "";

		CharBuffer cb = CharBuffer.wrap(input);
		while (cb.hasRemaining()) {
			char tempChar = cb.get();

			if (tempChar == '"') {
				xmlString += "&quot;";
			} else if (tempChar == '&') {
				xmlString += "&amp;";
			} else if (tempChar == '\'') {
				xmlString += "&apos;";
			} else if (tempChar == '<') {
				xmlString += "&lt;";
			} else if (tempChar == '>') {
				xmlString += "&gt;";
			} else {
				xmlString += tempChar;
			}
		}

		return xmlString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(toXMLString("\""));
		System.out.println(toXMLString("&"));
		System.out.println(toXMLString("'"));
		System.out.println(toXMLString("<"));
		System.out.println(toXMLString(">"));
	}
}
