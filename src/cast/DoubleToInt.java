package cast;

public class DoubleToInt {

	public static void main(String[] args) {
		byte _byte = 12;
		int _int = 123;
		long _long = 12;
		float _float = 1.23f;
		double _double = 123.123;
		String str;
		 
		// Byte <-> String
//		str = Byte.toString(_byte);
//		_byte = Byte.parseByte(str);
//		                 
//		// Integer <-> String
//		str = Integer.toString(_int);
//		_int = Integer.parseInt(str);
//		                 
//		// Long <-> String
//		str = Long.toString(_long);
//		_long = Long.parseLong(str);
//		                 
//		// Float <-> String
//		str = Float.toString(_float);
//		_float = Float.parseFloat(str);
//		                 
//		// Double <-> String
//		str = Double.toString(_double);
//		_double = Double.parseDouble(str);;
		
				
				
		String per = "-1";
		System.out.println(Integer.parseInt(per.split("\\.")[0]));
		System.out.println(Integer.parseInt(per.split("\\.")[0]) >= 80);
		
		
		String tmp = "01";
		System.out.println(Integer.parseInt(tmp));
		
	}

}
