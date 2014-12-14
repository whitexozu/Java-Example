package string;

import java.util.HashMap;

public class JQGridData {
	public static void main(String[] args) {
		String temp = "CHK, CLP_NO, CLP_DATE, TANS_DATE, BKGCNT, LINE_NAME, POD_NAME, VESSEL_NAME, VOYAGE_NO, PACKAGE, WEIGHT, SCBM, CBM, IN_PERSON, CONTAINER_NO, SEAL_NO, ENTERING_NO";
		String names[] = temp.split(",");
		
		JQGridMethod method = new JQGridMethod();
		HashMap<String , String> map = method.words();
		
		StringBuffer sb = new StringBuffer();


		int index = 0;
		String dot = "";
		String Word = "";
		sb.append("colNames:[");
		sb.append("\n");
		for(String s : names){
			dot = index!=0 ? "," : "";
			Word = map.get(s.trim())==null ? "" : map.get(s.trim());
			sb.append("\t");
			sb.append(dot+"\"<span class='wordSpan' text='"+s.trim()+"'>"+Word+"</span>\"");
			sb.append("\n");
			index++;
		}
		sb.append("],");
		sb.append("\n");
		sb.append("colModel:[");
		sb.append("\n");
		index = 0;
		for(String s : names){
			dot = index!=0 ? "," : "";
			Word = method.toCamelCase(s.trim());
			sb.append("\t");
			sb.append(dot+"{name:'"+Word+"', index:'"+Word+"', width:100, align:'center', sortable:false, hidden:false}");
			sb.append("\n");
			index++;
		}
		sb.append("],");
		sb.append("groupHeaders:[");
		sb.append("\n");
		sb.append("]");
		
		System.out.println(sb);

	}
}
