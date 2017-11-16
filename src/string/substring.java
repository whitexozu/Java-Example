package string;

public class substring {
	
	public static void main(String[] args) {
		String temp = "/TA_SKM/common/selectCommonCodeList.do";
		
		System.out.println( temp.substring(temp.lastIndexOf("/") + 1, temp.length()).startsWith("view") );
		
		
	}

}
