package connection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;

import connection.GoogleResults.Result;

public class GoogleSearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String google = "http://ajax.googleapis.com/ajax/services/search/web?v=2.0&q=";
		String search = "보터콜리";
		String charset = "UTF-8";
		System.out.println("1");
		try {
			URL url = new URL(google + URLEncoder.encode(search, charset));
			Reader reader = new InputStreamReader(url.openStream(), charset);
			GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

		    // Show title and URL of 1st result.
//		    System.out.println(results.getResponseData().getResults().get(0).getTitle());
//		    System.out.println(results.getResponseData().getResults().get(0).getUrl());
		    
		    for (Result r : results.getResponseData().getResults()) {
			    System.out.println(r.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
