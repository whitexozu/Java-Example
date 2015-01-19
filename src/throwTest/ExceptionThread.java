package throwTest;


public class ExceptionThread {

	// TODO Auto-generated method stub
	public static void main(String[] args) {
		try {
			String temp = method1();
			System.out.println("continure?? : "+temp);
		} catch (Exception e) {
			System.out.println("Exception?? : " + ExceptionTraceUtil.getStackTrace(e));
//			System.out.println("Exception?? : " + e);
		}
	}

	// 예외 던지기 : throw 로 예외를 던질때는 메서드에
	// throws Exception(던질 예외들) 선언해줘야 함.
	// 현재 메서드를 실행할 경우 Exception, ArithmeticException 발생 할 수
	// 있다고 선언해준 형태 입니다.
	public static String method1() throws Exception, ArithmeticException {
		System.out.println(1);
		method2();
		return "test";
	}

	// return 일 경우도 finally 호출
	public static void method2() {
		System.out.println(2);
		method3();
	}

	// String 문자열을 담는 Exception 생성
	public static void method3() {
		System.out.println(3);
		System.out.println(0/0);
//		try {
//			throw new Exception("직접만든 Exception");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}


}
