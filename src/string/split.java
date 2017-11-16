package string;

import java.util.Arrays;


public class split {

	/**
	 * summary.
	 * <PRE>
	 * 1. MethodName : main
	 * 2. ClassName  : split
	 * 4. Author     : jhkim-win7
	 * 5. Date       : 2013. 8. 20. ���� 3:30:07
	 * </PRE>
	 *   @return void
	 *   @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String temp = "2013-01-02";
//		String[] array = temp.split("-");
//		System.out.println(array[0]);
//		System.out.println(array[1]);
//		System.out.println(array[2]);
//		
//		String temp2 = "shipDateA";
//		String no = temp2.substring(temp2.length()-1);
//		String before = temp2.substring(0, temp2.length()-1);
//		System.out.println(temp2 + " , " + no  + " , " + before);
		
//		String[] chooseColumn = {"ID", "REGDATE", "R_PROD1"};
//		System.out.println(Arrays.asList(chooseColumn).indexOf("R_PROD1"));
		
		
		
		
		
		
//		String temp = "111";
//		String temp = "111;aaa,222;bbb,;33";
//		for(String tempsop : temp.split(",")) {
//			System.out.println("tempsop : " +  tempsop + ", " + tempsop.split(";")[0] + " , " + tempsop.split(";").length);
//		}
		
//		String temp = "10354648022^509323034^RPROD127^1^0^024^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0";
//		String temp = "10438057093^11392635821^RPROD130^0^0^^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0";
//		String temp = "-998^_^RPROD127^0^0^^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0";
//		System.out.println(temp.split("\\^").length);
		
//		String joined = String.join(",", temp.split("\\^"));
//		System.out.println(joined);
		
		
		
		
		
		
		
//		String temp = "P_티비&A_상담원&S_주다,P_티비&A_신호&S_주다";
//		String[] eventList = temp.split(",");
//		
//		String event_detail_code = "";
//		for(int i = 0; i < eventList.length; i++) {
//			
//			
//			String subjectCode = eventList[i].split("&")[0].substring(2);
//			String objectCode = eventList[i].split("&")[1].substring(2);
//			String predicateCode = eventList[i].split("&")[2].substring(2);
//			event_detail_code += subjectCode + ";" + objectCode + ";" + predicateCode + ",";
//		}
//		event_detail_code = event_detail_code.substring(0, event_detail_code.length() - 1);
//		
//		System.out.println("event_detail_code : " + event_detail_code);
		
		
		
		
		
		
		String temp = "가가가,나나나나,다다다다,라라라";
		for(String s : (String []) temp.split(",")) {
			System.out.println(s);
		}
	}
}
