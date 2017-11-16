package method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodTest {
	public long l = 9575;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		GetMethodTest cls = new GetMethodTest();
		Class c = cls.getClass();

		System.out.println("getClass값 = " + c);

		try {
			// getMethod(매서드이름, 매개변수)
			// parameter type is null
			Method m = c.getMethod("show", null);
			System.out.println("method1 = " + m.toString());
		}

		catch (NoSuchMethodException e) {
			System.out.println(e.toString());
		}

		try {
			// method Long
			Class[] cArg = new Class[1];
			cArg[0] = Long.class;
			Method lMethod = c.getMethod("showLong", cArg);
			
			Object obj = c.newInstance();
			long l2 = 10;
			lMethod.invoke(obj, l2);
			System.out.println("method1 = " + lMethod.toString());
			System.out.println("method2 = " + cls.getLong());
		} catch (NoSuchMethodException e) {
			System.out.println("exception = " + e.toString());
		}
	}

	public Integer show() {
		return 1;
	}

	public void showLong(Long l) {
		this.l = l;
	}
	
	public long getLong() {
		return l;
	}

}
