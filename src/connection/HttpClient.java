package connection;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpClient {
	private Logger log = LoggerFactory.getLogger(HttpClient.class);
	
	private final String DEFAULT_ENCODING = "UTF-8";
    private final String CONTENT_TYPE     = "application/x-www-form-urlencoded";

    private String url;
    private List<NameValuePair> params;
    
    public HttpClient(String url, List<NameValuePair> params) {
        this.url = url;
        this.params = params;
    }
    
    public String send() throws Exception {
    	
    	SSLContextBuilder builder = new SSLContextBuilder();
        SSLConnectionSocketFactory sslsf = null;
        String resJson = null;

        try {
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            sslsf = new SSLConnectionSocketFactory(builder.build(), SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", new PlainConnectionSocketFactory())
                    .register("https", sslsf)
                    .build();
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(5); // increase max total connection

            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm).build();
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(4 * 1000)
                    .setSocketTimeout(6 * 1000)
                    .build();

            HttpPost post = new HttpPost(url);
            post.setConfig(config);
            post.setHeader("Content-Type", CONTENT_TYPE);
            post.setEntity(new UrlEncodedFormEntity(this.params, DEFAULT_ENCODING));

            log.info("[HttpClient] (URL) " + url);

            CloseableHttpResponse response = httpClient.execute(post);
            log.info("[HttpClient] (RES) HTTP Status : " + response.getStatusLine());

            HttpEntity entity = response.getEntity();
            resJson = EntityUtils.toString(entity, DEFAULT_ENCODING);
            log.info("[HttpClient] (RES) result String : " + resJson);
            EntityUtils.consume(entity);

            response.close();
            post.releaseConnection();
            httpClient.close();

        } catch (Exception e) {
        	e.printStackTrace();
            throw e;
        }
        
        return resJson;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("carrierId", ""));
//        params.add(new BasicNameValuePair("requestId", "seqid1111"));
//        params.add(new BasicNameValuePair("contentId", "vocde2222"));
//        params.add(new BasicNameValuePair("isSuccess", "true"));
//		HttpClient hc = new HttpClient("http://211.234.232.11:8010/rcv/backoffice/callbackSetContentUploadingResult", params);
		
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("PARTNER_ID", "O00128"));
//        params.add(new BasicNameValuePair("SERVICE_CODE", "001"));
//        params.add(new BasicNameValuePair("MUSIC_CODE", "00293876"));
//        params.add(new BasicNameValuePair("CONTENT_PRICE", "800"));
//        params.add(new BasicNameValuePair("CONTENT_NAME", "핑계"));
//        params.add(new BasicNameValuePair("CONTENT_NUM", "1"));
//        params.add(new BasicNameValuePair("PID", "3102306023"));
//        params.add(new BasicNameValuePair("SUB_CODE", "1270000017"));
//        params.add(new BasicNameValuePair("CARRIER_CODE", "00"));
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("start", "0"));
        params.add(new BasicNameValuePair("as_sdt", "0,5"));
        params.add(new BasicNameValuePair("hl", "ko"));
        params.add(new BasicNameValuePair("q", "불면증"));
        
        for(NameValuePair v : params) {
        	System.out.println(v.getName() + " : " + v.getValue());
        }
        
//        HttpClient hc = new HttpClient("http://211.234.232.168/popup/search_mcode_dcmf2.jsp", params);
//        HttpClient hc = new HttpClient("https://scholar.google.co.kr/scholar", params);
        HttpClient hc = new HttpClient("http://localhost:8080/TA_SKM/ta/openApi/insertMntrLog.do", params);
        
		try {
			hc.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

}
