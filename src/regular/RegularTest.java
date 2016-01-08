package regular;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegularTest {
 
	public static void main(String[] args) {
		
		String line = "검색결과 약 73,200개 (0.61초)";
//		String line = "This order was placed for QT3000! OK?";
//		String pattern = "(.*)(\\d+)(.*)";
		String pattern = "(.*)(\\()(.*)(\\))";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
//			System.out.println("Found value 0 : " + m.group(0));
//			System.out.println("Found value 1 : " + m.group(1));
			System.out.println(m.group(1).replaceAll("[^0-9]", ""));
//			System.out.println("Found value 2 : " + m.group(2));
//			System.out.println("Found value 3 : " + m.group(3));
//			System.out.println("Found value 4 : " + m.group(4));
		} else {
			System.out.println("NO MATCH");
		}
	}
}