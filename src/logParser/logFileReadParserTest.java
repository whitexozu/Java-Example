package logParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class logFileReadParserTest {
	private static String logFile[] = {//"C:/Dev/workspace/javaExample/src/logParser/batchLog.txt"
									"C:/Dev/workspace/javaExample/src/logParser/apiLog.txt"
									//, "C:/Dev/workspace/javaExample/src/logParser/receiverLog.txt"
		};
	
	private static String methodName[] = {"mlbBatch", "rcvBatch", "clsBatch"};
	
//	private static String logEntryPatternMlb = "^\\[([\\S \\S]+)\\] (\\S+)(\\s+)(\\S+) \\[([\\S]+)\\] (\\S+)\t(\\S+) \"(.*)\"\t(\\S+) \"(.*)\" (\\S+)";
	private static String logEntryPatternMlb = "^\\[([\\S \\S]+)\\] (\\S+)(\\s+)(\\S+) \\[([\\S]+)\\] (\\S+)\t(\\S+) \"(.*)\"\t(\\S+) \"(.*)\"\t(\\S+) (\\S+) (\\S+) (\\S+)";
	
	private static Map<String, Integer> countMap = null;
	private static Map<String, String> messageMap = null;
	private static List<String[]> files = null;
	private static List<String> logDay = null;
	
	public static void main(String[] args) throws Exception {

		FileReader fr = null;
		BufferedReader br = null;
		Date d = null;
		

		logFileReadParserTest rt = new logFileReadParserTest();
		
		messageMap = new HashMap<String, String>();
		countMap = new HashMap<String, Integer>();
		files = new ArrayList<String[]>();
		
		//요일 확인 후 파일 목록 지정
		try {
			
			// 오늘날짜
			System.out.println(rt.getDay(0));
			
			// 대상 날짜 수
			int num = rt.getLogDayNum();
			System.out.println(num);
			
			// 대상 날짜
			logDay = new ArrayList<String>();
			for (int i=num; i>=1; i--) {
				Calendar logCal = new GregorianCalendar();
				logCal.add(Calendar.DATE, -i);
				String lDate = String.valueOf(logCal.get(Calendar.YEAR)) + String.valueOf(logCal.get(Calendar.MONTH) + 1) + String.valueOf(logCal.get(Calendar.DAY_OF_MONTH));
				System.out.println(i + " lDate ; " + lDate);
				logDay.add(lDate);
			}
			
			// 대상 파일목록
			for (String s : logFile) {
				String[] tfile = new String[2];
				String path = s.substring(0, s.lastIndexOf("/") + 1);
				String fileName = s.substring(s.lastIndexOf("/") + 1, s.length());
//				System.out.println(path);
//				System.out.println(fileName);
//				System.out.println("logFile : " + fileName);
				tfile[0] = path;
				tfile[1] = fileName;
				
				for (String l : logDay) {
					String[] bfile = new String[2];
					bfile[0] = path;
					bfile[1] = fileName+"."+l;
					files.add(bfile);
				}
				files.add(tfile);
			}
			
//			for(String[] s : files){
//				System.out.println(">>>>" + s[0] + s[1]);
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			//countMap init
			logDay.add(rt.getDay(0).replace("-", ""));
			String lDay = "";
			for (String n : methodName){
				for (String l : logDay) {
					lDay = l.substring(4, 6) + "/" + l.substring(6, 8);
					System.out.println("logDay >>>>" + lDay);
					
					if(!countMap.containsKey(n + "_" + lDay + "_A")){
						countMap.put(n + "_" + lDay + "_A", 0);
					}
					if(!countMap.containsKey(n + "_" + lDay + "_F")){
						countMap.put(n + "_" + lDay + "_F", 0);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	
		
		for(String[] lf : files){
			try {
				if (new File(lf[0] + lf[1]).exists()){
					System.out.println(lf[0] + lf[1] + " exists");
					
					fr = new FileReader(lf[0] + lf[1]);
					br = new BufferedReader(fr);
		
					String s = null;
					
					d = new Date();
					long start = d.getTime();
		
					while ((s = br.readLine()) != null) {
						rt.setLogMessage(s);
					}
		
					d = new Date();
					long end = d.getTime();
		
					System.out.println("------------------------------------------------ 처리 시간 : " + (end - start));
	
				}else{
					System.out.println(lf[0] + lf[1] + " not exists");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
					}
				if (fr != null)
					try {
						fr.close();
					} catch (IOException e) {
					}
			}
		}
		
		String[] temp = new String[countMap.size()];
		int i = 0; 
		for(Entry<String, Integer> entry : countMap.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
		    temp[i] = key + "_" + value;
		    i++;
		}
				
		Arrays.sort(temp);
		
		String result = "";
		for(String s : temp){
			System.out.println("-->"+s);
			String[] array = s.split("_");
			
			if(!messageMap.containsKey(array[0])) {
				messageMap.put(array[0], "");
			}
			result = messageMap.get(array[0]);
			if("A".equals(array[2])){
				result = result + array[1] + " - 전체:" +array[3];
			}
			else if("F".equals(array[2])){
				result = result + ", F:" +array[3] + "\\n";
			}
			messageMap.put(array[0], result);
		}
		
		for(Entry<String, String> entry : messageMap.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println(">>>"+key+":"+value);
		}
		
	}
	
	public String getDay(int i) {
		Calendar todayCal = new GregorianCalendar();
//		int year = todayCal.get(Calendar.YEAR);          // 연도를 리턴
//		int month = todayCal.get(Calendar.MONTH);    // 월을 리턴
//		int date = todayCal.get(Calendar.DATE);          // 일을 리턴
//		int amPm = todayCal.get(Calendar.AM_PM);    // 오전/오후 구분을 리턴
//		int hour = todayCal.get(Calendar.HOUR);         // 시를 리턴
//		int min = todayCal.get(Calendar.MINUTE);       // 분을 리턴
//		int sec = todayCal.get(Calendar.SECOND);      // 초를 리턴
		if(i != 0) todayCal.add ( todayCal.DATE, i ); 
		String yDate = String.valueOf(todayCal.get(Calendar.YEAR)) + "-" + String.valueOf(todayCal.get(Calendar.MONTH) + 1) + "-" + String.valueOf(todayCal.get(Calendar.DAY_OF_MONTH));
		return yDate;
	}
	
	public int getLogDayNum() {
		Calendar todayCal = new GregorianCalendar();
		int num = (todayCal.get(todayCal.DAY_OF_WEEK) == 2) ? 3 : 1;
		return num;
	}
	
	public void setLogMessage(String s) throws Exception {
		try {
			Pattern p = Pattern.compile(logEntryPatternMlb);
			Matcher m = p.matcher(s);
			
			System.out.println("===============================================");
			System.out.println("["+m.matches()+"] : "+s);
			if (m.matches()) {
				System.out.println("0 : " + m.group(0));
				System.out.println("1 : " + m.group(1));	//date
				System.out.println("2 : " + m.group(2));	//INFO, ERROR
				System.out.println("3 : " + m.group(3));
				System.out.println("4 : " + m.group(4));
				System.out.println("5 : " + m.group(5));
				System.out.println("6 : " + m.group(6));	//Method Name
				System.out.println("7 : " + m.group(7));
				System.out.println("8 : " + m.group(8));
				System.out.println("9 : " + m.group(9));
				System.out.println("10 : " + m.group(10));
				System.out.println("11 : " + m.group(11));
				System.out.println("12 : " + m.group(12));
				System.out.println("13 : " + m.group(13));
				System.out.println("14 : " + m.group(14));
				
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat logFormat = new SimpleDateFormat("MM/dd");
				Date aDate = transFormat.parse(getDay(0) + " 09:00:00");
				Date bDate = transFormat.parse(getDay(-getLogDayNum()) + " 09:00:00");
				Date logDate = transFormat.parse(m.group(1));
//				System.out.println(bDate+" : "+logDate+" : "+aDate);
//				System.out.println(">>>>> "+bDate.compareTo(logDate) +">>>>>>>>>>"+aDate.compareTo(logDate));
				
				int cnt = 0;
				if(bDate.compareTo(logDate) ==  -1 && aDate.compareTo(logDate) == 1){
					String reportDate = logFormat.format(logDate);
					
					System.out.println("add log count, " + m.group(6) + ", " + reportDate + ", " + m.group(2));
					
					cnt = countMap.get(m.group(6) + "_" + reportDate + "_A");
					countMap.put(m.group(6) + "_" + reportDate + "_A", ++cnt);
					
					if("ERROR".equals(m.group(2))) {
						cnt = countMap.get(m.group(6) + "_" + reportDate + "_F");
						countMap.put(m.group(6) + "_" + reportDate + "_F", ++cnt);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
