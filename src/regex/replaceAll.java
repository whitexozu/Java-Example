package regex;

public class replaceAll {

	public static void main(String[] args) {
//		1. []으로 싸주면 문자자체로 인식하는 것들.
//		* ⇒ [*]
//		+ ⇒ [+]
//		$ ⇒ [$]
//		| ⇒ [|]
//		? ⇒ [?]
				
//		2. \\를 붙여줘야 하는 것들.
//		( ⇒ \\(
//		) ⇒ \\)
//		{ ⇒ \\{
//		} ⇒ \\}
//		^ ⇒ \\^
//		[ ⇒ \\[
//		] ⇒ \\]

//		3. 자바의 특수문자는 \을 쓴다.
//		" ⇒ \"

//		4. 나머지 부호들은 괜찮은 듯 하다.
//		확인된 것.
//		! # % & @ ` : ; - . < > , ~ '

		String c = "111ab?$(){}*+^|[]cd가나다";
		c = c.replaceAll("[?][$]\\(\\)\\{\\}[*][+]\\^[|]\\[\\]", "");
		System.out.println(c);
		
		c = "111ab!#%&@'<>,.~cd가나다";
		c = c.replaceAll("!#%&@'<>,.~", "");
		System.out.println(c);

	}

}
