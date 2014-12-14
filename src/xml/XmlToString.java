package xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlToString {

	public String convertStringFromXml() throws Exception {
		File file = new File("src/xml/KCS_DeclarationOfReleaseOfDomesticGoodsSchemaModule_1.0.0_standard.xml");
		BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
		String line;
		StringBuilder sb = new StringBuilder();

		while((line=br.readLine())!= null){
		    sb.append(line.trim());
		}
		
		return sb.toString();
	}
	
	public void convertFileFromXml(String xml) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(new InputSource(new StringReader(xml)));
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("D:\\XmlDomCreate.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
	}

	public static void main(String[] args) throws Exception {
		String key, value;
		int num;
		XmlToString xts = new XmlToString();
		String str = xts.convertStringFromXml();
		System.out.println("str : "+str);
		
		Map<String, Object> eleMap = new HashMap<String, Object>();
		char[] charArray = str.toCharArray();
		int sw = 0;
		String cStr = "";
		for(char c : charArray){
//			System.out.println(c);
			if(c == '#'){
				sw = (sw == 0 ? 1 : 0);
			}
			if(sw == 1){
				cStr += c;
			}else{
				if(!"".equals(cStr)){
					eleMap.put(cStr.replace("#", ""), 0);
					cStr = "";
				}
			}
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("ReleaseDeclarationQuantity", "5HB");
		map.put("Description", "5HB");
		map.put("Quantity", "5HB");
		map.put("ReleaseDeclarationDocumentReferenceID", "5HB");
		map.put("PartyName", "5HB");
		map.put("ReleaseReason", "5HB");
		map.put("CompanyName", "5HB");
		map.put("AddressID", "5HB");
		map.put("ReleaseDeclarationPreviousCustomsDocumentReferenceID", "5HB");
		map.put("ReleaseGoodsTypeCode", "5HB");
		map.put("TypeCode", "5HB");
		map.put("DocumentReferenceID", "5HB");
		map.put("BondedAreaTypeCode", "5HB");
		map.put("FunctionTypeCode", "5HB");
		map.put("ReleaseDate", "5HB");
		map.put("ReleaseMeasure", "5HB");
//		map.put("measureUnitCode", "5HB");
		
		for(Entry<String, Object> entry : eleMap.entrySet()) {
		    key = entry.getKey();
		    num = (Integer)entry.getValue();
//		    System.out.println(key+" : "+num);
		    if(map.get(key)!=null){
		    	eleMap.put(key, 1);
		    }
		}
		
		if(eleMap.containsValue(0)){
			System.out.println("1818181818");
		}
		
		
		for(Entry<String, String> entry : map.entrySet()) {
		    key = entry.getKey();
		    value = entry.getValue();
		    str = str.replace("#"+key+"#", value);
		}
		
		
		
//		xts.convertFileFromXml(str);
		System.out.println("str : "+str);
	}

}
