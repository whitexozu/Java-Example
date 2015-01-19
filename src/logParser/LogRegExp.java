package logParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRegExp {

	
	public static final String logEntryLineRcv = "[2014-12-11 10:55:06.043] INFO - [70050003001] rcvBatch	(REQ) carrierId=SKTKR&requestId=B-20141211105100-SKTKR-1001323&contentId=70050003001&isSuccess=true	(RES) {\"ok\":true,\"errorState\":null} (MlbTasklet.java:173)";
	public static final String logEntryLineEcgDownload = "[2014-12-17 13:35:43.854] INFO  - [ECG] SktEcgDownload (REQ) PROD_ID=NA00004412&SVC_FLAG=I3&MDN=01071802226&SVC_MGMT_NUM=7219430807&MESG_ID=201412170000021422507767	(REQ) <dow:DownloadResponse xmlns:dow=\"http://sktelecom.com/ecg/download\"><dow:RESULT>N00000</dow:RESULT><dow:ERROR_MESG>OK</dow:ERROR_MESG></dow:DownloadResponse>	(ELAPSED_TIME) 193 ms (SktEcgDownloadController.java:147)";
	public static final String logEntryLineEcgDownloadError = "[2014-12-17 13:35:43.854] ERROR - [ECG] SktEcgDownload (REQ) NA00004412&SVC_FLAG=I3&MDN=01071802226&SVC_MGMT_NUM=7219430807&MESG_ID=201412170000021422507767	(EXCEPTION) java.lang.ArithmeticException: / by zero";
	
	public static final String[] logEntryLineApi = {
//									"[2014-12-23 10:53:53.991] INFO  - [01063958995] setRbtProfile (REQ) RbtProfile [carrierId=SKTKR, msisdn=01063958995, introGreeting=null, rbtSettings=[RbtSetting [caller=01027062989, contentIds=[70050002000]]]]	(RES) McsResponse [error=null, ok=true]	(ELAPSED_TIME) 662 ms (RbtContentsController.java:198)"
//									,"[2014-12-23 10:57:48.709] INFO  - [01063958995] addRbtProfile (REQ) RbtProfile [carrierId=SKTKR, msisdn=01063958995, introGreeting=null, rbtSettings=[RbtSetting [caller=01030683810, contentIds=[70050002902]]]]	(RES) McsResponse [error=null, ok=true]	(ELAPSED_TIME) 642 ms (RbtContentsController.java:198)"
									"[2014-12-19 21:14:43.161] INFO  - [01035515113] requestForUnsubscription (REQ) carrierId=SKTKR&msisdn=821035515113	(RES) McsResponse [error=McsError [type=SystemInternalError, code=SYSTEM_INTERNAL_NETWORK_ERROR, message=SKTelecom 부가서비스 해지 실패., reason=[ECG] (ErrorCode) ZNGME0068 (ErrorMessage) [리슨_컬러링 정액]는 사용중인 상품이 아니므로 해지할 수 없습니다.], ok=false]	(ELAPSED_TIME) 1223 ms (RbtSubscriptionController.java:223)"
//									,"[2014-12-22 14:45:32.348] INFO  - [01038632226] requestForUnsubscriptionWithMgmtNumber	(REQ) carrierId=SKTKR&msisdn=821038632226&serviceManagementNumber=7219430777&carrierProductId=NA00004412	(RES) McsResponse [error=null, ok=true]	(ELAPSED_TIME) 2281 ms (RbtSubscriptionController.java:284)"
									,"[2014-12-22 11:34:09.948] INFO  - [01035515113] checkSubscriptionStatus (REQ) carrierId=SKTKR&msisdn=821035515113	(RES) StatusResponse [McsResponse [error=McsError [type=ApplicationException, code=APP_USER_NOT_FOUND, message=SKTelecom CRBT 연동 오류., reason=오류코드 0x03 이 발생하였습니다.], ok=false], status=null]	(ELAPSED_TIME) 344 ms (RbtSubscriptionController.java:89)"
								};
	
	public static void apiParser(String s) {
//		String logEntryPatternApi = "^\\[([\\S \\S]+)\\] (\\S+)(\\s+)(\\S+) \\[([\\S]+)\\] (\\S+) (\\S+) (.*)\t(\\S+) (.*$)";
//		String logEntryPatternApi = "^\\[([\\S \\S]+)\\] (\\S+)(\\s+)(\\S+) \\[([\\S]+)\\] (\\S+) (\\S+) (.*)\t(\\S+) (.*)\t(\\S+) (.*$)";
		String logEntryPatternApi = "^\\[([\\S \\S]+)\\] (\\S+)(\\s+)(\\S+) \\[([\\S]+)\\] (\\S+)[ ,\t](\\S+) (.*)\t(\\S+) (.*)\t(\\S+) (.*$)";
		String logEntryPatternApiRes = "(\\S+) \\[(error=)(.*)(, ok=)(\\S+)\\]";
		String logEntryPatternApierror = "(\\S+) \\[(type=)(\\S+)(, code=)(\\S+)(, message=)(.*)(, reason=)(.*)\\]";
		
		Pattern p = Pattern.compile(logEntryPatternApi);
		Matcher m = p.matcher(s);
		
		System.out.println("===============================================");
		System.out.println("["+m.matches()+"] : "+s);
		if (m.matches()) {
//			System.out.println("0 : " + m.group(0));
//			System.out.println("1 : " + m.group(1));	//date
//			System.out.println("2 : " + m.group(2));	//INFO, ERROR
//			System.out.println("3 : " + m.group(3));
//			System.out.println("4 : " + m.group(4));
//			System.out.println("5 : " + m.group(5));
//			System.out.println("6 : " + m.group(6));	//Method Name
//			System.out.println("7 : " + m.group(7));	//(REQ)
//			System.out.println("8 : " + m.group(8));	
//			System.out.println("9 : " + m.group(9));	//(RES)
			System.out.println("10 : " + m.group(10));
//			System.out.println("11 : " + m.group(11));
//			System.out.println("12 : " + m.group(12));
			
			
			int beginIndex = m.group(10).indexOf("code=");
			int endIndex = m.group(10).substring(beginIndex).indexOf(",");
			String errCode = m.group(10).substring(beginIndex+5, beginIndex+endIndex);
			System.out.println(errCode);
			
			
//			Pattern resp = Pattern.compile(logEntryPatternApiRes);
//			Matcher resm = resp.matcher(m.group(10));
//			System.out.println("["+resm.matches()+"] : "+m.group(10));
//			if (resm.matches()) {
//				System.out.println("res 0 : " + resm.group(0));
//				System.out.println("res 1 : " + resm.group(1));
//				System.out.println("res 2 : " + resm.group(2));	//error=
//				System.out.println("res 3 : " + resm.group(3));
//				System.out.println("res 4 : " + resm.group(4));	//, ok=
//				System.out.println("res 5 : " + resm.group(5));
				
				
				
//				Pattern errp = Pattern.compile(logEntryPatternApierror);
//				Matcher errm = errp.matcher(resm.group(3));
//				System.out.println("["+errm.matches()+"] : "+resm.group(3));
//				if (errm.matches()) {
//					System.out.println("res 0 : " + errm.group(0));
//					System.out.println("res 1 : " + errm.group(1));
//					System.out.println("res 2 : " + errm.group(2));
//					System.out.println("res 3 : " + errm.group(3));
//					System.out.println("res 4 : " + errm.group(4));
//					System.out.println("res 5 : " + errm.group(5));
//				}
//			}
		}
	}
	
	public static void ecgDownloadParser() {
		String logEntryPatternEcgDownloadError = "^\\[([\\S \\S]+)\\] (\\S+)(\\s+)(\\S+) \\[([\\S]+)\\] (\\S+) (\\S+) (.*)\t(\\S+) (.*$)";
		Pattern p = Pattern.compile(logEntryPatternEcgDownloadError);
		Matcher m = p.matcher(logEntryLineEcgDownloadError);
		
		System.out.println("===============================================");
		System.out.println("["+m.matches()+"] : "+logEntryLineEcgDownload);
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
		}
	}
	
	public static void main(String argv[]) {
		for(String s : logEntryLineApi) {
			apiParser(s);
		}
//		ecgDownloadParser();
	}
}
