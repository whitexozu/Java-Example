package Integer;

public class IntegerTest {

	int nval;
	Integer ncls;
	public int getNval() {
		return nval;
	}
	public void setNval(int nval) {
		this.nval = nval;
	}
	public Integer getNcls() {
		return ncls;
	}
	public void setNcls(Integer ncls) {
		this.ncls = ncls;
	}
	
	public static void main(String[] args) {
		IntegerTest it = new IntegerTest();
		
		//1. Integer null 체크
		Integer i = null;
		System.out.println(i == null);
		
		//2. int -> Integer & Integer -> Interger & Integer null 체크
		int j = 5;
//		it.setNum(j);
		it.setNcls(j);
		
//		System.out.println(it.getNval());
		System.out.println(it.getNcls());
		
//		i = it.getNval();
		i = it.getNcls();

		System.out.println(i == null);
		
		//3. Integer -> int 
		int k = i;
		System.out.println(k);
		
	}

}
