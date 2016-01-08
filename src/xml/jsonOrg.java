package xml;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class jsonOrg {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
            "<breakfast_menu>\n" +
                    "<food>\n" +
                    "<name>Belgian Waffles</name>\n" +
                    "<price>$5.95</price>\n" +
                    "<description>\n" +
                    "Two of our famous Belgian Waffles with plenty of real maple syrup\n" +
                    "</description>\n" +
                    "<calories>650</calories>\n" +
                    "</food>\n" +
                    "<food>\n" +
                    "<name>Strawberry Belgian Waffles</name>\n" +
                    "<price>$7.95</price>\n" +
                    "<description>\n" +
                    "Light Belgian waffles covered with strawberries and whipped cream\n" +
                    "</description>\n" +
                    "<calories>900</calories>\n" +
                    "</food>\n" +
                    "</breakfast_menu>";
    public static String TEST_xml = 
    		"<?xml version ='1.0' encoding ='UTF-8'?>" +
    				"<!DOCTYPE DOC [" +
    				"<!ELEMENT DOC (XMLINFO, XMLLIST+)>" +
    				"<!ELEMENT XMLINFO (QUERY, PAGE, HITS, TOTAL,DOCCOUNT)>" +
    				"<!ELEMENT QUERY ANY> <!--검색어-->" +
    				"<!ELEMENT PAGE (#PCDATA)> <!--페이지-->" +
    				"<!ELEMENT HITS (#PCDATA)> <!--검색된건수-->" +
    				"<!ELEMENT TOTAL (#PCDATA)> <!--전체건수-->" +
    				"<!ELEMENT DOCCOUNT (#PCDATA)> <!--페이지당건수-->" +
    				"<!ELEMENT XMLLIST (NO, VdkVgwKey, GU, AN, AD, TL, AP)>" +
    				"<!ELEMENT NO (#PCDATA)> <!--순서-->" +
    				"<!ELEMENT VdkVgwKey (#PCDATA)> <!--Primarykey-->" +
    				"<!ELEMENT GU (#PCDATA)> <!--권리-->" +
    				"<!ELEMENT AN (#PCDATA)> <!--출원번호/국제등록번호-->" +
    				"<!ELEMENT AD (#PCDATA)> <!--출원일자-->" +
    				"<!ELEMENT TL (#PCDATA)> <!--발명의명칭-->" +
    				"<!ELEMENT AP (#PCDATA)> <!--출원인-->" +
    				"]>" +
    				"<DOC>" +
    				"<XMLINFO>" +
    				"<QUERY>자동차</QUERY>" +
    				"<PAGE>1</PAGE>" +
    				"<HITS>438797</HITS>" +
    				"<TOTAL>3724459</TOTAL>" +
    				"<DOCCOUNT>10</DOCCOUNT>" +
    				"</XMLINFO>" +
    				"<XMLLIST>" +
    				"<NO>1</NO>" +
    				"<VdkVgwKey>1020070112929</VdkVgwKey>" +
    				"<GU>KP</GU>" +
    				"<AN>1020070112929</AN>" +
    				"<AD>20071105</AD>" +
    				"<TL>자동차 연료 카본 타임 수정(자동차 energy.carbon TIME 수정)</TL>" +
    				"<AP>민병수</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>2</NO>" +
    				"<VdkVgwKey>2020117000029</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020117000029</AN>" +
    				"<AD>20110915</AD>" +
    				"<TL>자동차용 광 필터 조립체(Light-filtering assembly used on vehicle)</TL>" +
    				"<AP>후앙, 웬 트세</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>3</NO>" +
    				"<VdkVgwKey>2020140002988</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020140002988</AN>" +
    				"<AD>20140414</AD>" +
    				"<TL>자동차의 핸들커버(Handle cover for vehicle)</TL>" +
    				"<AP>주식회사 카렉스</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>4</NO>" +
    				"<VdkVgwKey>2020117000030</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020117000030</AN>" +
    				"<AD>20110915</AD>" +
    				"<TL>수납식 자동차용 광 필터 조립체(Stowed-type light-filtering assembly for vehicle)</TL>" +
    				"<AP>후앙, 웬 트세</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>6</NO>" +
    				"<VdkVgwKey>2020090013802</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020090013802</AN>" +
    				"<AD>20091021</AD>" +
    				"<TL>자동차용 매트(A car mat)</TL>" +
    				"<AP>이상연</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>7</NO>" +
    				"<VdkVgwKey>2020080005334</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020080005334</AN>" +
    				"<AD>20080423</AD>" +
    				"<TL>자동차의 엔진배기관 연결부용 차열판(Car hot plate for automotive engine exhaust pipe connection)</TL>" +
    				"<AP>박순희</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>9</NO>" +
    				"<VdkVgwKey>2020110000863</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020110000863</AN>" +
    				"<AD>20110128</AD>" +
    				"<TL>자동차용 헤드 램프(A Head Lamp for vehicles)</TL>" +
    				"<AP>에스엘 주식회사</AP>" +
    				"</XMLLIST>" +
    				"<XMLLIST>" +
    				"<NO>10</NO>" +
    				"<VdkVgwKey>2020080003292</VdkVgwKey>" +
    				"<GU>KU</GU>" +
    				"<AN>2020080003292</AN>" +
    				"<AD>20080313</AD>" +
    				"<TL>자동차용 햇빛가리개(Sun screen for vehicle)</TL>" +
    				"<AP>김용전</AP>" +
    				"</XMLLIST>" +
    				"</DOC>";
    public static void main(String[] args) {
        try {
//            JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
            JSONObject xmlJSONObj = XML.toJSONObject(TEST_xml);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    }


}
