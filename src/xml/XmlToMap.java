package xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlToMap {

	private static Map<String, String> contentMap; 
			
	public static Map<String, String> convertNodesFromXml(String xml) throws Exception {
		File stocks = new File("src/xml/KCS_ApplicationForExtensionOfReleasePeriodSchemaModule_1.0.0_standard.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(stocks);
		
//		InputStream is = new ByteArrayInputStream(xml.getBytes());
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		dbf.setNamespaceAware(true);
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document document = db.parse(is);
		
		return createMap(document.getDocumentElement(), 1, "");
	}

	public static Map<String, String> createMap(Node node, int dept, String parentNodeName) {
		
		String tag = "";
		for(int j=0; j<dept; j++){
			tag += ">>";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		NodeList nodeList = node.getChildNodes();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			
			String nodePath = ("".equals(parentNodeName)) ? currentNode.getNodeName() : parentNodeName+"/"+currentNode.getNodeName();
			
			if(currentNode.getNodeType() == 1){
				if(currentNode.getChildNodes().getLength() > 1){
					map.putAll(createMap(currentNode, dept+1, nodePath));
				}else if(!"#text".equals(currentNode.getFirstChild().getNodeName())){ 
					map.putAll(createMap(currentNode, dept+1, nodePath));
				}else{
					map.put(nodePath, currentNode.getTextContent());
				}
				
				if (currentNode.hasAttributes()) {
					NamedNodeMap attrs = currentNode.getAttributes();
					for(int k=0; k<attrs.getLength(); k++){
						Node item = attrs.item(k);
						map.put(nodePath+"@"+item.getNodeName(), item.getTextContent());
					}
				}
			}
		}
		
		return map;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = XmlToMap.convertNodesFromXml("");
		System.out.println("=============== ajax source =================");
		System.out.println("var search_params = {");
		System.out.println("\t'query' : '-',");
		System.out.println("\t'url' : '/SendEdi.do',");
		System.out.println("\t'fileName' : 'testjhim.xml',");
		System.out.println("\t'flag' : '1',");
		for(Entry<String, String> entry : map.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println("\t'"+key+"' : '"+value+"',");
		}
		System.out.println("};");
		
		System.out.println("=============== map source =================");
		System.out.println("Map<String, String> contentMap = new HashMap<String, String>();");
		for(Entry<String, String> entry : map.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    System.out.println("contentMap.put(\""+key+"\", \""+value+"\");");
		}
	}

}
