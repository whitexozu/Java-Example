package connection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class NdslApiTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		long start = System.currentTimeMillis();
		
		List<Map<String, Object>> searchList = new ArrayList<Map<String, Object>>();
		Map<String, Object> reqMap = new HashMap<String, Object>();
//		reqMap.put("srchText", "소프트 로봇");
		reqMap.put("srchText", "and");
		reqMap.put("target", "ARTI");
		reqMap.put("target", "PATENT");
		reqMap.put("target", "REPORT");
		reqMap.put("target", "ATT");
		reqMap.put("target", "STAN");
		
		reqMap.put("searchField", "BI");
		reqMap.put("displayCount", "10");
		reqMap.put("startPosition", "1");
		reqMap.put("sortby", "title");
		reqMap.put("orderby", "asc");
		
		String srchText = (String) reqMap.get("srchText");
		String target = (String) reqMap.get("target");
		String searchField = (String) reqMap.get("searchField");
		String displayCount = (String) reqMap.get("displayCount");
		String startPosition = (String) reqMap.get("startPosition");
		String sortby = (String) reqMap.get("sortby");
		String orderby = (String) reqMap.get("orderby");
		String charset = "UTF-8";
		
		String apiUrl = "http://openapi.ndsl.kr/itemsearch.do?keyValue=07655251&version=2.0" +
				"&target="+target+
				"&query="+URLEncoder.encode(srchText, charset)+
				"&searchField="+searchField+
				"&displayCount="+displayCount+
				"&startPosition="+startPosition+
				"&sortby="+sortby+
				"&orderby="+orderby+
				"&responseGroup=simple"+
				"&returnType=xml";
		
		System.out.println("apiUrl : " + apiUrl);
		try {
			int size = 0;
			String title = "";
			String link = "";
			NdslApiTest nat = new NdslApiTest();
			String xmlResult = nat.httpSender(apiUrl);
//			System.out.println(xmlResult);
			
			JSONObject xmlJSONObj = XML.toJSONObject(xmlResult);
			JSONObject MetaData = (JSONObject) xmlJSONObj.get("MetaData");
			JSONObject resultSummary = MetaData.getJSONObject("resultSummary");
			size = Integer.parseInt((String) resultSummary.get("totalCount"));
			if ( size == 0 ) {
				System.out.println("size : " + size);
				System.out.println("xml null");
				xmlJSONObj.put("success", false);
			} else {
				System.out.println("size : " + size);
				System.out.println("xml not null");
				xmlJSONObj.put("success", true);
				
				JSONObject outputData = MetaData.getJSONObject("outputData");
				int len =  ((JSONArray) outputData.get("record")).length();
				for(int i=0; i < len; i++) {
					System.out.println(i+"=========");
					
					Map<String, Object> map = new HashMap<String, Object>();
					
					JSONObject o = (JSONObject) ((JSONArray) outputData.get("record")).get(i);
					if("ARTI".equals(target)) {
						if(o.has("articleInfo")) {
							title = (String) o.getJSONObject("articleInfo").getJSONObject("articleTitleInfo").getString("articleTitle");
							link = (String) o.getJSONObject("articleInfo").getString("deeplink");
						}else if(o.has("dissertation")) {
							title = (String) o.getJSONObject("dissertation").getString("dissertationTitle");
							link = (String) o.getJSONObject("dissertation").getString("deeplink");
						}
					} else if("PATENT".equals(target)) {
						if(o.has("patentInfo")) {
							title = (String) o.getJSONObject("patentInfo").getString("patentTitle");
							link = (String) o.getJSONObject("patentInfo").getString("deepLink");
						}
					} else if("REPORT".equals(target)) {
						if(o.has("reportInfo")) {
							title = (String) o.getJSONObject("reportInfo").getJSONObject("reportTitleInfo").getString("reportTitle");
							link = (String) o.getJSONObject("reportInfo").getString("deepLink");
						}
					} else if("ATT".equals(target)) {
						if(o.has("trendAnalysisInfo")) {
							title = (String) o.getJSONObject("trendAnalysisInfo").getJSONObject("trendAnalysisTitleInfo").getString("trendAnalysisTitle");
							link = (String) o.getJSONObject("trendAnalysisInfo").getString("deepLink");
						}
					} else if("STAN".equals(target)) {
						if(o.has("standardInfo")) {
							title = (String) o.getJSONObject("standardInfo").getString("title");
							link = (String) o.getJSONObject("standardInfo").getString("deepLink");
						}
					}
					map.put("title", title);
					map.put("link", link);
					
					System.out.println(title);
					System.out.println(link);
					
					searchList.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
	    System.out.println("실행 시간 : " + ( end - start )/1000.0 );
	}
	
	public String httpSender(String apiUrl) throws Exception {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader reader = null;
		String result = "";
		try {
			URL url = new URL(apiUrl);

			is = url.openStream();
			isr = new InputStreamReader(is, "utf-8"); // 인코딩
			reader = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = null;
			String tmpStr = null;
			while ((line = reader.readLine()) != null) {
				tmpStr = line.toString();
				tmpStr = tmpStr.replaceAll(" ", "");
				if (!tmpStr.equals(""))
					buffer.append(line).append("\r\n");
			}

			// REST API 결과값
			result = buffer.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(is != null)
				is.close();
			if(isr != null)
				isr.close();
			if(reader != null)
				reader.close();
		}
		return result;
	}

}
