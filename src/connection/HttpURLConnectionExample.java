package connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		http.sendGet();
	}

	// HTTP GET request
	private void sendGet() throws Exception {

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String jobId = sf.format(new Date(System.currentTimeMillis()));
		String key = "CL";
		String type = "D";
		String state = "S";
		String serviceKey = "b7a9dce1-9a39-4382-8b94-910220b5";
		
		String urlParameters = "?jobId="+jobId+"&key="+key+"&type="+type+"&state="+state+"&serviceKey="+serviceKey;
		
//		String url = "http://localhost:8080/TA_SKM/ta/openApi/insertMntrLog.do"+urlParameters;
		String url = "http://172.17.68.67:2000?WorkCode=0001&StartTm=20180101&ExtnNum=05328&Callid=01b702b2ecda3a3b159024989&dstPath=ta_voice";
		url= "http://172.17.68.67:2000?WorkCode=0001&StartTm=20180314&ExtnNum=00821&Callid=01b202b844fc1bfd158407409&dstPath=ta_voice";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
//
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		con.disconnect();
	}
}