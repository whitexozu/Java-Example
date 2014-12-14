package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteToFileForUdf {

//	public static final String[][][] insAmtSendUnb = {
//		{
//			{"M"," ","3","UNB"},	//1	
//			{" ","M","4","KECA"},	//2
//			{"M","","","1"},	//3
//			{" ","M","","@ktSendId"},	//2
//			{"M"," ","","57"},	//3
//			{" ","M","","@ktRecvId"},	//2
//			{"M"," ","","57"},	//3
//			{" ","M","","="},	//4
//			{"M"," ","","="},	//5
//			{" ","M","","@seqNo"}	//5
//		}
//	};
	public static final String[][][] insAmtSendHeader = {
		{
			{"M"," ","3","UNB"},	//1	
			{" ","M","4","KECA"},	//2
			{"M","","","1"},	//3
			{" ","M","","@ktSendId"},	//2
			{"M"," ","","57"},	//3
			{" ","M","","@ktRecvId"},	//2
			{"M"," ","","57"},	//3
			{" ","M","","="},	//4
			{"M"," ","","="},	//5
			{" ","M","","@seqNo"}	//5
		},
		{
			{"M"," ","14","UNH"},	//1	
			{"M"," ","","1"},	//2
			{" ","M","6","CUSBCR"},	//3
			{" ","M","1","S"},	//4
			{" ","M","3","93A"},	//5
			{" ","M","2","KE"},	//6
		},
		{
			{"M"," ","","BGM"},	//1	
			{" ","M","3","5HK"},	//2
			{"M"," ","18","@seqNo"},	//3
			{"M"," ","1","9"}	//4
		},
		{
			{"M"," ","","DTM"},	//1	
			{" ","M","3","150"},	//2
			{" ","M","8","@rcvDate"},	//3
			{" ","M","3","9"}	//4
		},
		{
			{"M"," ","","DTM"},	//1	
			{" ","M","2","150"},	//2
			{" ","M","12","=yyyyMMddhhmm"},	//3
			{" ","M","3","9"}	//4
		},
		{
			{"M"," ","","LOC"},	//1	
			{"M"," ","2","18"},	//2
			{" ","M","25","@whNm"},	//3
			{" ","M","",""},	//4
			{" ","M","",""},	//5
			{" ","M","8","@whCd"}	//6
		}
	};
	public static final String[][][] insAmtSendSG7Sg8_2 = {
		{
			{"M"," ","14","DOC"},	//1	
			{" ","M","3","5HA"},	//2
			{" ","N","",""},	//3
			{" ","N","",""},	//4
			{" ","M","18","@seqNo"},	//5
			{"C"," ","",""},	//6
			{" ","M","16","@bl"},	//7
			{" ","N","",""},	//8
			{" ","C","18","@seqNo"},	//9
		},
		{
			{"M"," ","","PAC"},	//1	
			{"N"," ","8","@pkgQty"},	//2
			{"M"," ","",""},	//3
			{" ","M","2","@pkgCd"}	//4
		},
		{
			{"M"," ","","HAN"},	//1	
			{" ","N","",""},	//2
			{" ","N","",""},	//3
			{" ","N","",""},	//4
			{" ","M","10","@locPlace"}	//5
		},
		{
			{"M"," ","","FTX"},	//1	
			{"N"," ","3","AHH"},	//2
			{"N"," ","",""},	//3
			{"M"," ","",""},	//4
			{" ","M","12","@insEntrance"}	//5
		},
		{
			{"M"," ","","FTX"},	//1	
			{"N"," ","3","ICN"},	//2
			{"N"," ","",""},	//3
			{"M"," ","",""},	//4
			{" ","M","35","@cneeNm"}	//5
		},
		{
			{"M"," ","","MEA"},	//1	
			{"N"," ","2","WT"},	//2
			{"M"," ","",""},	//3
			{" ","M","2","KG"},	//4
			{" ","M","16","@wt"}	//5
		},
		{
			{"M"," ","","GID"},	//1	
			{"M"," ","3",""},	//2
		},
		{
			{"M"," ","","GIS"},	//1	
			{" ","M","1",""},	//2
			{" ","M","3","121"},	//3
			{" ","M","3","KCS"},	//4
		},
		{
			{"M"," ","","GIS"},	//1	
			{" ","M","1","@goodsType"},	//2
			{" ","M","3","166"},	//3
			{" ","M","3","6KT"},	//4
		}
	};
	
	public static String getRPad(String str, int size, String strFillText) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str += strFillText;
        }
        return str;
    }
	
	public static String createUdf(List<Map<String, Object>> list, String[] arrName){
		
		Map<String, String[][][]> docData = new HashMap<String, String[][][]>();
		StringBuffer sb = new StringBuffer("");
		
		docData.put("insAmtSendHeader", insAmtSendHeader);
		docData.put("insAmtSendSG7Sg8_2", insAmtSendSG7Sg8_2);
		
		boolean headerFlag = false;
		for(Map<String, Object> map: list){
			for(int j=0; j<arrName.length; j++){
				if(headerFlag && j==0) continue;
				String an = arrName[j];
				loop:
				for(String[][] s2 : docData.get(an)){
					for(int i=0; i<s2.length; i++){
						String[] s1 = s2[i];
						if("C".equals(s1[0])){
							for(int k=i; k<s2.length; k++){
								if("M".equals(s2[k][1]) && s2[k][3].indexOf("@") > -1 && ("".equals(map.get(s2[k][3].substring(1))) || map.get(s2[k][3].substring(1))==null)){
									sb.delete(sb.length()-1, sb.length());
									sb.append("'");
									continue loop;
								}
							}
						}
						if("C".equals(s1[1]) && s1[3].indexOf("@") > -1 && ("".equals(map.get(s1[3].substring(1))) || map.get(s1[3].substring(1))==null)){
							sb.delete(sb.length()-1, sb.length());
							continue;
						}else{
							if(s1[3].indexOf("@") > -1){
								if("".equals(s1[2])){
									sb.append(map.get(s1[3].substring(1)) == null ? "" : map.get(s1[3].substring(1)));
								}else{
									sb.append(map.get(s1[3].substring(1)) == null ? "" : getRPad((String)map.get(s1[3].substring(1)), Integer.parseInt(s1[2]), " "));
								}
							}else{
								if("".equals(s1[2])){
									sb.append(s1[3]);
								}else{
									sb.append(getRPad(s1[3], Integer.parseInt(s1[2]), " "));	
								}
							}
							if((i+1)!=s2.length){
//								if("M".equals(s1[0].trim())){
								if(!"".equals(s1[0].trim())){
									sb.append("+");
								}else{
									sb.append(":");
								}
							}
						}
					}
					sb.append("'");
				}
			}
			headerFlag = true;
		}
		
		
		System.out.println(sb.toString().replace("'", "'\n"));
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("seqNo", "WH0011300000001");
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();
		Map<String, Object> listMap2 = new HashMap<String, Object>();
		listMap1.put("seqNo", "WH0011300000001");
		listMap1.put("bl", "1234");
		
//		listMap2.put("seqNo", "WH0011300000002");
		listMap2.put("bl", "1234");
		list.add(listMap1);
		list.add(listMap2);
		
		
		
		createUdf(list, new String[]{"insAmtSendHeader", "insAmtSendSG7Sg8_2"});
		
		

//		FileWriter fw = null;
//		BufferedWriter bw = null;
//		try {
//
//			String content = "This is the content to write into file";
//
//			File file = new File("filename.txt");
//
//			// if file doesnt exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			fw = new FileWriter(file.getAbsoluteFile());
//			bw = new BufferedWriter(fw);
//			bw.write(content);
//
//			System.out.println("Done");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			bw.close();
//		}
	}
}
