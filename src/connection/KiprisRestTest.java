package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class KiprisRestTest {
	public static void main(String[] args) {
//		REST API URL은 http://도메인/openapi/rest/서비스명/오퍼레이션명 으로 이루어져있으며, 승인받은 접근키 값과 각각의 오퍼레이션에서 필요로 하는 입력 값(Request Parameter)을 입력합니다.
//		 해외특허 > 서지정보 > 서지상세정보 REST API 호출 URL. URL은 홈페이지 DATA 상세정보에서 확인 가능.
//		[도메인/openapi/rest/서비스명/오퍼레이션명]으로 구성.
//		String apiUrl = "http://plus.kipris.or.kr/openapi/rest/ForeignPatentBibliographicService/bibliographicInfo";
		String apiUrl = "http://link.kipris.or.kr/link/search/XTOTAL.jsp?reg_key=aWH8o12WLpsy30NoItNS5Q%3D%3D&GU=KP&Query=자동차&currentPage=1&docCount=5";
//		String apiUrl = "http://link.kipris.or.kr/link/search/XTOTAL.jsp?reg_key=aWH8o12WLpsy30NoItNS5Q%3D%3D&GU=KP&Query=뷁&currentPage=1&docCount=10";
		
		// 해당 상품 승인 접근키. 회원가입 후 자동발급되며 마이페이지에서 확인 가능.
//		String accessKey = "aWH8o12WLpsy30NoItNS5Q%3D%3D";
		// 입력값 문헌번호 & 국가코드
//		String literatureNumber = "198100001145A1";
//		String countryCode = "AP";

//		apiUrl += "?accessKey=" + accessKey + "&literatureNumber=" + literatureNumber + "&countryCode=" + countryCode;
		System.out.println("apiUrl : " + apiUrl);
		try {
			// REST API URL을 읽어들여 결과 출력한다
			URL url = new URL(apiUrl);

			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 인코딩
			BufferedReader reader = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = null;
			String tmpStr = null;
			while ((line = reader.readLine()) != null) {
				tmpStr = line.toString();
				tmpStr = tmpStr.replaceAll(" ", "");

				if (!tmpStr.equals(""))
					buffer.append(line).append("\r\n");
			}
			reader.close();

			// REST API 결과값
			String xmlResult = buffer.toString();

//			System.out.println("ForeignPatentBibliographicService/bibliographicInfo RESULT => " + xmlResult);
			
			JSONObject xmlJSONObj = XML.toJSONObject(xmlResult);
			JSONObject obj = (JSONObject) xmlJSONObj.get("DOC");
			if ( obj.has("XMLLIST") ) {
				System.out.println( "HITS : " + ((JSONObject)obj.get("XMLINFO")).get("HITS") );
				
				System.out.println("xml not null");
				xmlJSONObj.put("success", true);
			} else {
				System.out.println("xml null");
				xmlJSONObj.put("success", false);
			}
			
			System.out.println( ((JSONArray) obj.get("XMLLIST")).length() );
			int len =  ((JSONArray) obj.get("XMLLIST")).length();
			for(int i=0; i < len; i++) {
				System.out.println(i+"=========");
				JSONObject o = (JSONObject) ((JSONArray) obj.get("XMLLIST")).get(i);
				System.out.println(o.get("TL"));
				System.out.println(o.get("AN"));
				System.out.println(o.get("AP"));
				System.out.println(o.get("GU"));
				System.out.println(o.get("AD"));
				
			}
			
//            String jsonPrettyPrintString = xmlJSONObj.toString(4);
//            System.out.println(jsonPrettyPrintString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
