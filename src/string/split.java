package string;

import java.util.Arrays;
import java.util.regex.Pattern;


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
		
		
		
		
		
		
//		String temp = "가가가,나나나나,다다다다,라라라";
//		String temp = "11,1212";
//		System.out.println( temp.length() > 0 ? ((String []) temp.split(",")).length : 0 );
		
//		for(String s : (String []) temp.split(",")) {
//			System.out.println(s);
//		}
		
//		String temp = "00011627_01639_20180212235842_20180212235954_0_01b202b47d97d68d158483368.dat";
//		temp = temp.substring(0, temp.lastIndexOf("."));
//		System.out.println("temp : " + temp);
//		String[] tempArr = temp.split("_");
//		for(String s : tempArr) {
//			System.out.println(s);	
//		}
		
		
		
//		String temp = "111|222|333|";
//		System.out.println( Arrays.toString(temp.split("\\|", -1)) );
		
		
//		String temp = "111\r\n222\r\n333\r\n";
//		System.out.println(temp.replace("\r\n", " "));
//		System.out.println( Arrays.toString(temp.split("\r\n")) );
		
		Pattern pattern = Pattern.compile("\\|");
		String t1 = "20180406_03146_01b202ba6909118e158626679|03146|158626679|01b202ba6909118e|20180406163516|F|021|F0005|F00053103|AA50512||||||25||01049003003|0|NO|163516|163541|꿈을 이루는 케이비 국민 은행 오영숙입니다;전화로 안녕하세요;그 그 출금;입출금 입출금 내역을 우리 팩스로 좀 보내드려야겠는데 네;그럼 시점에 도움드릴 수 있도록 예금 상담 직원 연결되겠습니다;예;아라 그러는데 그게 지금 네;홈페이지에 직원 연결해 드리겠습니다;예;감사합니다";
		String t2 = "20180406_02146_01b902b5cc0074a9158543727||||20180406163518|@|||||||||||||||||이거를 시켰던 건데요";
		String t3 = "20180406_02134_01b902b5cc0073fd158539202||||20180406163440|@||||||||||||||||";
		String[] arr1 = pattern.split(t1, -1);
		String[] arr2 = pattern.split(t2, -1);
		String[] arr3 = pattern.split(t3, -1);
		System.out.println(arr1[16]);
		System.out.println(arr1[17]);
//		System.out.println(arr2.length);
//		System.out.println(arr3.length);

	}
}
