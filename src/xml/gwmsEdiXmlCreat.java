package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class gwmsEdiXmlCreat {

	public static void main(String argv[]) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			if (true) {
				Element rootElement = doc.createElement("rsm:AmendmentOfReleaseOrCarryIn");
				rootElement.setAttribute("xmlns:ram", "urn:kr:gov:kcs:data:standard:KCS_AmendmentOfReleaseOrCarryInSchemaModule:1:0:0");
				rootElement.setAttribute("xmlns:ram", "urn:kr:gov:kcs:common:standard:KCS_ReusableAggregateBusinessInformationEntitySchemaModule:1:0:0");
				rootElement.setAttribute("xmlns:udt", "urn:un:unece:uncefact:common:standard:UNCEFACTUnqualifiedDataTypesSchemaModule:1:0:0");
				rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
				rootElement.setAttribute("xsi:schemaLocation", "urn:kr:gov:kcs:data:standard:KCS_AmendmentOfReleaseOrCarryInSchemaModule:1:0:0./schema/uncefact/data/KCS_AmendmentOfReleaseOrCarryInSchemaModule_1.0.0_standard.xsd");
				doc.appendChild(rootElement);

				// ApplicationTypeCode elements
				Element ApplicationTypeCode = doc.createElement("rsm:ApplicationTypeCode");
				ApplicationTypeCode.appendChild(doc.createTextNode("1"));
				rootElement.appendChild(ApplicationTypeCode);

				// ApplicationGradeNumeric elements
				Element ApplicationGradeNumeric = doc.createElement("rsm:ApplicationGradeNumeric");
				ApplicationGradeNumeric.appendChild(doc.createTextNode("1"));
				rootElement.appendChild(ApplicationGradeNumeric);

				// ApplicationGradeNumeric elements
				Element AmendmentReason = doc.createElement("rsm:AmendmentReason");
				AmendmentReason.appendChild(doc.createTextNode("정정사유"));
				rootElement.appendChild(AmendmentReason);

				// Document elements
				Element Document = doc.createElement("rsm:Document");
				rootElement.appendChild(Document);

				// TypeCode elements
				Element TypeCode = doc.createElement("ram:TypeCode");
				TypeCode.appendChild(doc.createTextNode("5LC"));
				Document.appendChild(TypeCode);

				// IssueDate elements
				Element IssueDate = doc.createElement("ram:IssueDate");
				IssueDate.appendChild(doc.createTextNode("2007-08-08"));
				Document.appendChild(IssueDate);

				// PreviousCustomsDocument elements
				Element PreviousCustomsDocument = doc.createElement("rsm:PreviousCustomsDocument");
				rootElement.appendChild(PreviousCustomsDocument);

				// referenceID elements
				Element referenceID = doc.createElement("ram:referenceID");
				referenceID.appendChild(doc.createTextNode("123456781212345678"));
				PreviousCustomsDocument.appendChild(referenceID);

				// ApplicationParty elements
				Element ApplicationParty = doc.createElement("rsm:ApplicationParty");
				rootElement.appendChild(ApplicationParty);

				// referenceID elements
				Element Name = doc.createElement("ram:Name");
				Name.appendChild(doc.createTextNode("홍길동"));
				ApplicationParty.appendChild(Name);

				// UCR elements
				Element UCR = doc.createElement("rsm:UCR");
				rootElement.appendChild(UCR);

				// IdentificationID elements
				Element IdentificationID = doc.createElement("ram:IdentificationID");
				IdentificationID.appendChild(doc.createTextNode("12345678901"));
				UCR.appendChild(IdentificationID);

				// MasterBLSequenceID elements
				Element MasterBLSequenceID = doc.createElement("ram:MasterBLSequenceID");
				MasterBLSequenceID.appendChild(doc.createTextNode("0001"));
				UCR.appendChild(MasterBLSequenceID);

				// HouseBLSequenceID elements
				Element HouseBLSequenceID = doc.createElement("ram:HouseBLSequenceID");
				HouseBLSequenceID.appendChild(doc.createTextNode("001"));
				UCR.appendChild(HouseBLSequenceID);

				for (int i = 0; i < 5; i++) {
					// AmendmentContent elements
					Element AmendmentContent = doc.createElement("rsm:AmendmentContent");
					rootElement.appendChild(AmendmentContent);

					// LineNumberID elements
					Element LineNumberID = doc.createElement("ram:LineNumberID");
					LineNumberID.appendChild(doc.createTextNode("001"));
					AmendmentContent.appendChild(LineNumberID);

					// BeforeDescription elements
					Element BeforeDescription = doc.createElement("ram:BeforeDescription");
					BeforeDescription.appendChild(doc.createTextNode("정정전내용"));
					AmendmentContent.appendChild(BeforeDescription);

					// AfterDescription elements
					Element AfterDescription = doc.createElement("ram:AfterDescription");
					AfterDescription.appendChild(doc.createTextNode("정정후내용"));
					AmendmentContent.appendChild(AfterDescription);
				}

			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("D:\\XmlDomCreate.xml"));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
