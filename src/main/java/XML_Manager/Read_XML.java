package XML_Manager;


import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;

import POJO.Drug_POJO;


import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  
public class Read_XML {
public static 	String path=System.getProperty("user.dir");
public static void main(String argv[])   
{  
	
	Drug_POJO obj=new Drug_POJO();
try   
{  
//creating a constructor of file class and parsing an XML file  
File file = new File(path+"\\src\\test\\resource\\input_XML\\ERx_request.xml");  
//an instance of factory that gives a document builder  
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
//an instance of builder to parse the specified xml file  
DocumentBuilder db = dbf.newDocumentBuilder();  
Document doc = db.parse(file);  
doc.getDocumentElement().normalize();  
System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
NodeList nodeList = doc.getElementsByTagName("DrugType");  
// nodeList is not iterable, so we are using for loop  
for (int itr = 0; itr < nodeList.getLength(); itr++)   
{  
Node node = nodeList.item(itr);  
System.out.println("\nNode Name :" + node.getNodeName());  
if (node.getNodeType() == Node.ELEMENT_NODE)   
{  
Element eElement = (Element) node;  

obj.setColumn1(eElement.getElementsByTagName("DosageFormCd").item(0).getTextContent());
obj.setColumn2( eElement.getElementsByTagName("DosageFormType").item(0).getTextContent());
obj.setColumn3( eElement.getElementsByTagName("DrugDefaultSig").item(0).getTextContent());
obj.setColumn4(eElement.getElementsByTagName("DrugStrength").item(0).getTextContent()); 
obj.setColumn5( eElement.getElementsByTagName("DrugStrengthUOM").item(0).getTextContent());
obj.setColumn6( eElement.getElementsByTagName("GPI").item(0).getTextContent());
obj.setColumn7( eElement.getElementsByTagName("NDC").item(0).getTextContent());
obj.setColumn8( eElement.getElementsByTagName("RouteOfAdminCodedVal").item(0).getTextContent());
obj.setColumn9(eElement.getElementsByTagName("SingleActiveIngredientInd").item(0).getTextContent());
obj.setColumn10(eElement.getElementsByTagName("DrugClassType").item(0).getTextContent());



System.out.println("DosageFormCd : "+  obj.getColumn1());  
System.out.println("DosageFormType : "+ obj.getColumn2());  
System.out.println("DrugDefaultSig : "+ obj.getColumn3());  
System.out.println("DrugStrength : "+   obj.getColumn4());
System.out.println("DrugStrengthUOM : "+   obj.getColumn5());

System.out.println("GPI : "+   obj.getColumn6());
System.out.println("NDC : "+   obj.getColumn7());
System.out.println("RouteOfAdminCodedVal : "+   obj.getColumn8());
System.out.println("SingleActiveIngredientInd : "+    obj.getColumn9());
System.out.println("DrugClassType : "+    obj.getColumn10());
}  
}  


}   
catch (Exception e)   
{  
e.printStackTrace();  
}  
}  
} 