package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteToFileForUdfNew {

	public static final String[][][] insAmtSendHeader = {
//		{
//			{"M"," ","3","UNB"},
//			{" ","M","4","KECA"},
//			{"M","","","1"},
//			{" ","M","","@ktSendId"},
//			{"M"," ","","57"},
//			{" ","M","","@ktRecvId"},
//			{"M"," ","","57"},
//			{" ","M","","="},
//			{"M"," ","","="},
//			{" ","M","","@seqNo"}
//		},
		{
			{"M"," ","","UNH"},
			{"M"," ","14","@seqNo"},
			{"M"," ","",""},
			{" ","M","6","CUSBCR"},
			{" ","M","1","S"},
			{" ","M","3","93A"},
			{" ","M","2","KE"},
		},
		{
			{"M"," ","","BGM"},
			{"M"," ","",""},
			{" ","M","3","5HK"},
			{"M"," ","18","@seqNo"},
			{"M"," ","1","9"}
		},
		{
			{"M"," ","","DTM"},
			{"M"," ","",""},
			{" ","M","3","150"},
			{" ","M","8","@rcvDate"},
			{" ","M","3","9"}
//		},
//		{
//			{"C"," ","","DTM"},	//1
//			{"M"," ","",""},
//			{" ","M","2","91"},
//			{" ","M","12","=yyyyMMddhhmm"},
//			{" ","M","3","203"}
		}
	};
	public static final String[][][] insAmtSendSG7Sg8_2 = {
		{
			{"M"," ","","DOC"},
			{"M"," ","",""},
			{" ","M","3","5HA"},
			{" ","N","",""},
			{" ","N","",""},
			{" ","M","18","@bl"},
			{"C"," ","",""},
			{" ","M","16","@bl"},
			{" ","N","",""},
			{" ","C","18","@seqNo"}
		},
		{
			{"C"," ","","DTM"},
			{"M"," ","",""},
			{" ","M","8","@bl"},
		},
		{
			{"M"," ","","DTM"},
			{"M"," ","",""},
			{" ","M","8","112233"},
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
		String bPos = "";
		String aPos = "";
		int cNum = 0;
		
		docData.put("insAmtSendHeader", insAmtSendHeader);
		docData.put("insAmtSendSG7Sg8_2", insAmtSendSG7Sg8_2);
		
		boolean headerFlag = false;
		for(Map<String, Object> map: list){
			for(int j=0; j<arrName.length; j++){
				if(headerFlag && j==0) continue;
				String an = arrName[j];
				loop:
				for(String[][] s2 : docData.get(an)){
					bPos = "";
					aPos = "";
					loop2:
					for(int i=0; i<s2.length; i++){
						String[] s1 = s2[i];
						
						if(i==0 && "C".equals(s1[0])){	//0 row C
							for(int k=i; k<s2.length; k++){
								if("M".equals(s2[k][1]) && s2[k][3].indexOf("@") > -1 && ("".equals(map.get(s2[k][3].substring(1))) || map.get(s2[k][3].substring(1))==null)){
//									sb.delete(sb.length()-1, sb.length());
//									sb.append("'");
									continue loop;
								}
							}
						}
						
						if(i!=0 && "C".equals(s1[0])){	//n row left C
							cNum = 0;
							for(int k=i+1; k<s2.length; k++){
//								System.out.println("k : "+k+" >>> " +s2[k][1]);
								if(!"".equals(s2[k][0].trim()) || k >= s2.length){
									break;
								}
								cNum++;
							};
							System.out.println("cNum : "+cNum);
							System.out.println("======================");
							for(int k=i+1; k<i+1+cNum; k++){
								System.out.println("i : "+i+", k : "+k+" >>> " +s2[k][1]+", "+s2[k][3]);
								if("M".equals(s2[k][1]) && s2[k][3].indexOf("@") > -1 && ("".equals(map.get(s2[k][3].substring(1))) || map.get(s2[k][3].substring(1))==null)){
									System.out.println(">>>>>> i : "+i+", k : "+k+" >>> " +s2[k][1]+", "+s2[k][3]);
//									sb.delete(sb.length()-1, sb.length());
									i = i + cNum;
									System.out.println(i + "===" + s2.length);
									
									continue loop2;
								}
							}
						}
						
//						System.out.println("i : "+i+" , "+s2.length);
						
						if(i-1 < 0){
							bPos = "";
						}else{
							bPos = !"".equals(s2[i-1][0].trim()) ? "left" : "right";
						}
						
						aPos = !"".equals(s1[0].trim()) ? "left" : "right";
						
//						System.out.println("bPos : "+bPos+", aPso : "+aPos);
						
						if("".equals(bPos) && "".equals(aPos)){
							
						}else if("".equals(bPos) && "left".equals(aPos)){
//							sb.append("+");
						}else if("left".equals(bPos) && "left".equals(aPos)){
							sb.append("+");
						}else if("left".equals(bPos) && "right".equals(aPos)){
//							sb.append("+");
						}else if("right".equals(bPos) && "left".equals(aPos)){
							sb.append("+");
						}else if("right".equals(bPos) && "right".equals(aPos)){
							sb.append(":");
						}

						if("C".equals(s1[1]) && s1[3].indexOf("@") > -1 && (map.get(s1[3].substring(1))==null || "".equals(map.get(s1[3].substring(1))))){	//n row right C
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
		
		listMap2.put("seqNo", "WH0011300000002");
//		listMap2.put("bl", "5678");
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
