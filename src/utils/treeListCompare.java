package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class treeListCompare {
//	private final static String treeListString = "[{\"id\":\"000000\",\"title\":\"admin\",\"children\":[{\"id\":\"new\",\"title\":\"new\",\"parentId\":\"000000\"},{\"id\":\"000000001\",\"title\":\"sub admin\",\"children\":[{\"id\":\"000000000\",\"title\":\"super admin\",\"children\":[],\"parentId\":\"000000001\"}],\"parentId\":\"000000\"}],\"parentId\":\"000\"},{\"id\":\"new\",\"title\":\"new\",\"parentId\":\"000000\"},{\"id\":\"000000001\",\"title\":\"sub admin\",\"children\":[{\"id\":\"000000000\",\"title\":\"super admin\",\"children\":[],\"parentId\":\"000000001\"}],\"parentId\":\"000000\"},{\"id\":\"000000000\",\"title\":\"super admin\",\"children\":[],\"parentId\":\"000000001\"},{\"id\":\"000001\",\"title\":\"user\",\"children\":[],\"parentId\":\"000\"}]";
	private final static String treeListString = "[{'id':'new','title':'new','parentId':'000'},{'id':'000000','title':'admin','children':[{'id':'000000001','title':'sub admin','children':[{'id':'000000000','title':'super admin','children':[],'parentId':'000000001'}],'parentId':'000000'}],'parentId':'000'},{'id':'000000001','title':'sub admin','children':[{'id':'000000000','title':'super admin','children':[],'parentId':'000000001'}],'parentId':'000000'},{'id':'000000000','title':'super admin','children':[],'parentId':'000000001'},{'id':'000001','title':'user','children':[{'id':'000001000','title':'default','children':[],'parentId':'000001'}],'parentId':'000'},{'id':'000001000','title':'default','children':[],'parentId':'000001'}]";
	public static void main(String[] args) {
		try {
			// 인자값인 String 을 JSONArray 로 변환
			JSONArray treeArray = new JSONArray(treeListString);
//			for(int i=0; i < treeList.length(); i++) {
//				JSONObject obj = treeList.getJSONObject(i);
//				System.out.println( obj.getString("parentId") );
//				System.out.println( obj.getString("id") );
//				System.out.println( obj.getString("title") );
//				System.out.println("--------------------------------------");
//			}
			List<HashMap<String, Object>> treeList = CommonUtil.jsonarray2list(treeArray);
			
//			listPrint(treeList);
			
			// 기존 treeList DB에서 조회
			List<HashMap<String, Object>> masterList = getOriginMasterTable();
			
//			listPrint(masterList);
			
			// 신규 ID 체번
			HashMap<String, Integer> seqMap = new HashMap<String, Integer>();
			int seqNum = 0;
			int seqLen = 3;
			String seqStr = "";
			for(HashMap<String, Object> hm : treeList) {
				// map 에 부모 id 를 저장하여 채번
				if( seqMap.containsKey(hm.get("parentId")) ) {
					seqNum = seqMap.get( hm.get("parentId") ) + 1;
					seqMap.put((String) hm.get("parentId"), seqNum);
				} else {
					seqMap.put((String) hm.get("parentId"), 0);
				}
				// 부모id+seqNum(공백 0으로 채움)
				seqStr = String.format("%s%0"+seqLen+"d", hm.get("parentId"), seqMap.get(hm.get("parentId")));
				hm.put("orgId", hm.get("id"));
				hm.put("newId", seqStr);
			}
			
//			listPrint(treeList);
			
			// 삭제 목록 제크
			List<HashMap<String, Object>> masterCloneList = new ArrayList<HashMap<String, Object>>();
			masterCloneList.addAll(masterList);
//			for(int i=0; i<masterCloneList.size(); i++) {
			for(int i=masterCloneList.size()-1; i>=0; i--) {
				HashMap<String, Object> hm = masterCloneList.get(i);
//				System.out.println(i + " : " + hm.get("ID"));
				for(int j=0; j<treeList.size(); j++) {
					HashMap<String, Object> obj = treeList.get(j);
//					System.out.println( "orgId : " + obj.getString("orgId") );
					if(obj.get("orgId").equals(hm.get("ID"))) {
						masterCloneList.remove(i);
						break;
					}
				}
			}
			
//			listPrint(masterCloneList);
			
			// 수정 목록 체크
			for(int i=0; i<treeList.size(); i++) {
				HashMap<String, Object> obj = treeList.get(i);
				if( "new".equals(obj.get("orgId")) ) {
					obj.put("updateFlag", "false");	
				} else {
					for(HashMap<String, Object> hm : masterList) {
						if( obj.get("orgId").equals(hm.get("ID")) ) {
							if( obj.get("parentId").equals(hm.get("PARENTID")) ) {
								obj.put("updateFlag", "false");	
							} else {
								obj.put("updateFlag", "true");	
							}
							break;
						}
					}
				}
			}
			
//			listPrint(treeList);
			
			// sub table 적용 (delete, update)
			//delete
			for(HashMap<String, Object> hm : masterCloneList) {
				System.out.println( "sub table delete title : " + hm.get("TITLE") );
			}
			// update
			for(HashMap<String, Object> hm : treeList) {
				if( "true".equals(hm.get("updateFlag")) ) {
					System.out.println( "sub table update title : " + hm.get("title") );
				}
			}
			
			// master table 적용 (insert)
			//delete
			
			//insert
			for(HashMap<String, Object> hm : treeList) {
				System.out.println( "master table insert parentId : " + hm.get("parentId") );
				System.out.println( "master table insert newId : " + hm.get("newId") );
				System.out.println( "master table insert title : " + hm.get("title") );
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public static void listPrint(List<HashMap<String, Object>> list) {
		System.out.println("===============================================");
		for (HashMap<String, Object> hm : list) {
			System.out.println("--------------------------------------");
			Set key = hm.keySet();
			for (Iterator iterator = key.iterator(); iterator.hasNext();) {
				String keyName = (String) iterator.next();
				String valueName = (String) hm.get(keyName);
				System.out.println(keyName + " = " + valueName);
			}
		}
	}
	
	public static List<HashMap<String, Object>> getOriginMasterTable(){
		List<HashMap<String, Object>> masterList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		hm1.put("LEVEL", "1");
		hm1.put("TITLE", "admin");
		hm1.put("PARENTID", "000");
		hm1.put("ID", "000000");
		masterList.add(hm1);
		
		HashMap<String, Object> hm2 = new HashMap<String, Object>();
		hm2.put("LEVEL", "2");
		hm2.put("TITLE", "super admin");
		hm2.put("PARENTID", "000000");
		hm2.put("ID", "000000000");
		masterList.add(hm2);
		
		HashMap<String, Object> hm3 = new HashMap<String, Object>();
		hm3.put("LEVEL", "2");
		hm3.put("TITLE", "sub admin");
		hm3.put("PARENTID", "000000");
		hm3.put("ID", "000000001");
		masterList.add(hm3);
		
		HashMap<String, Object> hm4 = new HashMap<String, Object>();
		hm4.put("LEVEL", "1");
		hm4.put("TITLE", "user");
		hm4.put("PARENTID", "000");
		hm4.put("ID", "000001");
		masterList.add(hm4);
		
		HashMap<String, Object> hm5 = new HashMap<String, Object>();
		hm5.put("LEVEL", "2");
		hm5.put("TITLE", "default");
		hm5.put("PARENTID", "000001");
		hm5.put("ID", "000001000");
		masterList.add(hm5);
		
        return masterList;
    }
	
}
