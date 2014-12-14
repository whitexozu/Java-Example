package regex;

public class camel {
	static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		int i = 0;
		for (String part : parts) {
			camelCaseString = camelCaseString + toProperCase(part, i);
			i++;
		}
		return camelCaseString;
	}

	static String toProperCase(String s, int i) {
		if(i==0){
			return s.toLowerCase();	
		}else{
			return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(toCamelCase("CARGO_TYPE"));
		System.out.println(toCamelCase("BOOKING_NO"));
		System.out.println(toCamelCase("SEQ"));
		System.out.println(toCamelCase("BOOKING_DATE"));
		System.out.println(toCamelCase("ENTERING_NO"));
		System.out.println(toCamelCase("ENTERING_DATE"));
		System.out.println(toCamelCase("SHPRCNEE_NAME"));
		System.out.println(toCamelCase("DISCHARGING_PORT_CODE"));
		System.out.println(toCamelCase("ETD"));
		System.out.println(toCamelCase("CNTR_TOTAL"));
		System.out.println(toCamelCase("WEIGHT"));
		System.out.println(toCamelCase("SHIPPER_CBM"));
		System.out.println(toCamelCase("CBM"));
		System.out.println(toCamelCase("CLP_NO"));
		System.out.println(toCamelCase("ASHIPPER_NAME"));
		System.out.println(toCamelCase("LOC_PLACE"));
		System.out.println(toCamelCase("LOC_NM"));
		System.out.println(toCamelCase("STORY_NO"));
		System.out.println(toCamelCase("ZONE_CD"));
		System.out.println(toCamelCase("STAIR_NO"));
		System.out.println(toCamelCase("ROW_NO"));
		System.out.println(toCamelCase("COLUMN_NO"));
		System.out.println(toCamelCase("MAX_ROW"));
		System.out.println(toCamelCase("MAX_COL"));
		System.out.println(toCamelCase("RACK_MAX_ROW"));
		System.out.println(toCamelCase("RACK_MAX_COL"));

	}
}
