package xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlToFile {

	public static Map<String, String> contentMap;
	
	public static Map<String, String> convertNodesFromXml(String xml) throws Exception {
		File stocks = new File("src/xml/KCS_DeclarationOfBLPartitionOrCancellationSchemaModule_1.0.0_standard.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(stocks);
		
//		InputStream is = new ByteArrayInputStream(xml.getBytes());
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		dbf.setNamespaceAware(true);
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document document = db.parse(is);
		
		createMap(document.getDocumentElement(), 1, "");
		createXmlFile(document);
		
//		XPathFactory xPathfactory = XPathFactory.newInstance();
//		XPath xpath = xPathfactory.newXPath();
//		XPathExpression expr = xpath.compile("");
		
		return null; 
	}
	
	public static void createXmlFile(Document document) throws TransformerException{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("D:\\XmlDomCreate.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
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
					createMap(currentNode, dept+1, nodePath);
				}else if(!"#text".equals(currentNode.getFirstChild().getNodeName())){ 
					createMap(currentNode, dept+1, nodePath);
				}else{
					System.out.println(nodePath+" : "+currentNode.getTextContent());
					currentNode.setTextContent(contentMap.get(nodePath));
					System.out.println(nodePath+" : "+currentNode.getTextContent());
				}
				
				if (currentNode.hasAttributes()) {
					NamedNodeMap attrs = currentNode.getAttributes();
					for(int k=0; k<attrs.getLength(); k++){
						Node item = attrs.item(k);
						item.setTextContent(contentMap.get(nodePath+"@"+item.getNodeName()));
//						map.put(nodePath+"@"+item.getNodeName(), item.getTextContent());
					}
				}
			}
		}
		
		return map;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		contentMap = new HashMap<String, String>();
		contentMap.put("rsm:PreviousCustomsDocument/ram:referenceID", "123");
		contentMap.put("rsm:PeriodExtensionPreviousCustomsDocument/ram:referenceID", "123");
		contentMap.put("rsm:Document/ram:FunctionTypeCode", "111");
		contentMap.put("rsm:ReleaseGoodsPackaging/ram:Quantity", "222");
		contentMap.put("rsm:UCR/ram:HouseBLSequenceID", "333");
		contentMap.put("rsm:Document/ram:TypeCode", "444");
		contentMap.put("rsm:UCR/ram:IdentificationID", "fsdfef");
		contentMap.put("rsm:CargoReleaseTypeCode", "gesbe");
		contentMap.put("rsm:UCR/ram:MasterBLSequenceID", "aaaaa");
		contentMap.put("rsm:ReleaseDateTime", "2001-12-18T09:30:47");
		contentMap.put("rsm:ReleasePeriodExtensionTypeCode", "cccc");
		contentMap.put("rsm:ReleaseCarriedInGradeNumeric", "vvvvv");
		contentMap.put("rsm:Document/ram:referenceID", "dddd");
		contentMap.put("rsm:ReleaseMeasure", "eeee");
		contentMap.put("rsm:ReleaseMeasure@measureUnitCode", "qqqq");
		contentMap.put("rsm:PartitionReleaseTypeCode", "gggggg");
		
		convertNodesFromXml("");
		
		
//		Map<String, String> map = XmlToFile.convertNodesFromXml("");
		System.out.println("=============== map value =================");
//		for(Entry<String, String> entry : map.entrySet()) {
//		    String key = entry.getKey();
//		    String value = entry.getValue();
//		    System.out.println(key+" : "+value);
//		}
	}

}
