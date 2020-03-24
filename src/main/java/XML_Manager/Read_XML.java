package XML_Manager;


import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  
public class Read_XML {

public static void main(String argv[])   
{  
try   
{  
//creating a constructor of file class and parsing an XML file  
File file = new File("C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\input_XML\\ERx_request.xml");  
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
System.out.println("DosageFormCd : "+ eElement.getElementsByTagName("DosageFormCd").item(0).getTextContent());  
System.out.println("DosageFormType : "+ eElement.getElementsByTagName("DosageFormType").item(0).getTextContent());  
System.out.println("DrugDefaultSig : "+ eElement.getElementsByTagName("DrugDefaultSig").item(0).getTextContent());  
System.out.println("DrugStrength : "+ eElement.getElementsByTagName("DrugStrength").item(0).getTextContent());  
System.out.println("DrugStrengthUOM : "+ eElement.getElementsByTagName("DrugStrengthUOM").item(0).getTextContent());  

System.out.println("GPI : "+ eElement.getElementsByTagName("GPI").item(0).getTextContent());  
System.out.println("NDC : "+ eElement.getElementsByTagName("NDC").item(0).getTextContent());  
System.out.println("RouteOfAdminCodedVal : "+ eElement.getElementsByTagName("RouteOfAdminCodedVal").item(0).getTextContent());  
System.out.println("SingleActiveIngredientInd : "+ eElement.getElementsByTagName("SingleActiveIngredientInd").item(0).getTextContent());  
System.out.println("DrugClassType : "+ eElement.getElementsByTagName("DrugClassType").item(0).getTextContent());  

}  
}  
}   
catch (Exception e)   
{  
e.printStackTrace();  
}  
}  
} 