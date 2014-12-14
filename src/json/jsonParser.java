package json;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jsonParser {

	private static String jsonText = "{'root':{'description':'naver auto commnet','TelephonyType':'','schedule':[{'actionType':'submit','description':'naver login','url':'https://nid.naver.com/nidlogin.login?svctype=262144&url=http://m.naver.com/','formName':'frmNIDLogin','values':[{'id':'purunnoni'},{'pw':'496ba1b828nv'}]},{'actionType':'comment','description':'naver comment test','url':'https://nid.naver.com/nidlogin.login?svctype=262144&url=http://m.naver.com/','formName':'frmNIDLogin','values':[{'commentValue':'good'}]},{'actionType':'search','description':'naver search test','url':'https://nid.naver.com/nidlogin.login?svctype=262144&url=http://m.naver.com/','formName':'frmNIDLogin','values':[{'query':'44444'}]}]}}";
//	private static String jsonText = "{'root':{'description':'naver auto commnet'}}";
	private static JSONObject jsonObject;
	private static JSONObject object; 
	private static JSONArray scheduleArray;
	private static JSONArray valueArray;
	private static JSONObject valueObject;
	private static String key; 
	
	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		jsonObject = new JSONObject(jsonText);
		object = jsonObject.getJSONObject("root");
		scheduleArray = object.getJSONArray("schedule");

		for (int i = 0; i < scheduleArray.length(); i++) {
			System.out.println("i : "+i);
			System.out.println("actionType : " + scheduleArray.getJSONObject(i).getString("actionType").toString());
			System.out.println("description : " + scheduleArray.getJSONObject(i).getString("description").toString());
			System.out.println("url : " + scheduleArray.getJSONObject(i).getString("url").toString());
			valueArray = scheduleArray.getJSONObject(i).getJSONArray("values");
			for (int j = 0; j < valueArray.length(); j++) {
				valueObject = valueArray.getJSONObject(j);
				Iterator<?> keys = valueObject.keys();
		        while( keys.hasNext() ){
		            key = (String)keys.next();
		            System.out.println(j+" key : "+key + " , " + valueObject.getString(key));
		        }
			}
		}
		
	}

}
