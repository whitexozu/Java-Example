package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpsClient {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new HttpsClient().testIt();
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}

	private void testIt() {
		String urlTags = "";
		Document doc = null;
		String pattern = "(.*)(\\()(.*)(\\))";
		boolean srchFlag = true;
		
		
		try {
			srchFlag = true;
			urlTags = HttpsSender("scholar", "불면증", "0");
//			urlTags = HttpsSender("scholar", "제모거라디머ㅠㅏㅣㄷ", "0");
			
			doc = Jsoup.parse(urlTags);
			
			String totalText = doc.select("div #gs_ab_md").first().text();
			System.out.println(totalText);
			
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(totalText);
			if (m.find()) {
				System.out.println(m.group(1).replaceAll("[^0-9]", ""));
			} else {
				System.out.println("NO MATCH");
				srchFlag = false;
			}
			
			if(srchFlag) {
				Elements listDiv = doc.select(".gs_ri");
				for(Element e : listDiv) {
					String link = e.select(".gs_rt a").attr("href");
					String title = e.select(".gs_rt").text();
					String auth = e.select(".gs_a").text();
					String content = e.select(".gs_rs").html();
					System.out.println("link : " + link);
					System.out.println("title : " + title);
					System.out.println("auth : " + auth);
					System.out.println("content : " + content);
					System.out.println("=========================");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------------------------------------------------");
		
		try {
			srchFlag = true;
			urlTags = HttpsSender("patent", "불면증", "0");
//			urlTags = HttpsSender("patent", "ㅁㅎㄷㅏㅣㅎㄷ둫ㄷ머ㅠㅏㅣㄷfjaelgjelkajklgje", "0");
			
			doc = Jsoup.parse(urlTags);
			
			String totalText = doc.select("div #resultStats").text();
			System.out.println(totalText);
			
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(totalText);
			if (m.find()) {
				System.out.println(m.group(1).replaceAll("[^0-9]", ""));
			} else {
				System.out.println("NO MATCH");
				srchFlag = false;
			}
			
			if(srchFlag) {
				Elements listDiv = doc.select(".rc");
				for(Element e : listDiv) {
					String link = e.select(".r a").attr("href");
					String title = e.select(".r").text();
					String detailUrl = e.select("._SWB").text();
					String summary = e.select(".slp").text();
					String content = e.select(".st").text();
//					String auth4 = e.select(".osl").text();
					System.out.println("link : " + link);
					System.out.println("title : " + title);
					System.out.println("detailUrl : " + detailUrl);
					System.out.println("summary : " + summary);
					System.out.println("content : " + content);
//					System.out.println("auth4 : " + auth4);
					System.out.println("=========================");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String HttpsSender(String urlType, String query, String start) throws Exception {
		StringBuilder sb = null;
		URLConnection connection = null;
		InputStreamReader isr = null;
		BufferedReader br  = null;
		String url = "";
		try {
			String charset = "UTF-8";
			String uQuery = "q=" + URLEncoder.encode(query, charset);
			
			if("scholar".equals(urlType)) {
				url = "https://scholar.google.co.kr/scholar?start="+start+"&"+uQuery+"&hl=ko&as_sdt=0,5";	
			} else if("patent".equals(urlType)) {
//				url = "https://www.google.co.kr/?tbm=pts&gws_rd=cr,ssl&ei=i7tzVo6MDKG2mwX5yLDADg#q="+uQuery+"&tbm=pts&start="+start;
//				url = "https://www.google.co.kr/search?tbo=p&tbm=pts&hl=en&"+uQuery+"&num=10";
				url = "https://www.google.co.kr/search?tbo=p&tbm=pts&hl=en&"+uQuery+"&num=10#"+uQuery+"&hl=en&tbm=pts&start="+start;
			}
			
			sb = new StringBuilder();
		
			System.out.println("url : "+url);
			connection = new URL(url).openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			isr = new InputStreamReader(connection.getInputStream(), Charset.forName(charset));
			br  = new BufferedReader(isr);
			
			String line;
			while ((line = br.readLine()) != null) {
			    sb.append(line);
			}
			
			System.out.println(sb.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(connection != null)
				connection = null;
			if(isr != null)
				isr.close();
			if(br != null)
				br.close();
		}
		
		return sb.toString();
	}
}