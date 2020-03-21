package XML_Manager;





import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Config_manager.FileReadManager;
import Excel_Manager.Drug_Sig;



public class BasicXml {
	
    public static void main(String[] args) throws Throwable {
    	
    	String in_XMLpath = FileReadManager.getInstance().getCr().getin_XMLpath();
    	String out_XMLpath = FileReadManager.getInstance().getCr().getResponse_XML();
    	
    	
    	
        File xmlFile = new File(in_XMLpath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
           
            
    /*        //update attribute value
          updateAttributeValue(doc);
            
            update Element value
           
            //delete element
      deleteElement(doc);*/
            
            //add new element
      // addElement(doc);
            
            //write the updated document to file or console
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            
            
            ArrayList<String> column0 = Drug_Sig.getColumn0();
            ArrayList<String> column1 = Drug_Sig.getColumn1();
            ArrayList<String> column2 = Drug_Sig.getColumn2();
            ArrayList<String> column3 = Drug_Sig.getColumn3();
            ArrayList<String> column4 = Drug_Sig.getColumn4();
            
            for (int i = 0; i < column0.size(); i++) {
            	String st0 = column0.get(i);
            	String st1 = column1.get(i);
            	String st2 = column2.get(i);
            	String st3 = column3.get(i);
            	String st4 = column4.get(i);
            	
            	 updateElementValue(doc, st0,st1,st2,st3,st4);
            StreamResult result = new StreamResult(new File(out_XMLpath+i+".xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
          
            }
            //System.out.println(out_XMLpath);
        
            System.out.println("file updated successfully =====> "+out_XMLpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addElement(Document doc) {
        NodeList patienttype = doc.getElementsByTagName("PatientType");
        Element emp = null;
        
        //loop for each employee
        for(int i=0; i<patienttype.getLength();i++){
            emp = (Element) patienttype.item(i);
            Element salaryElement = doc.createElement("flag_id");
            salaryElement.appendChild(doc.createTextNode("DBA"));
            emp.appendChild(salaryElement);
        }
    }

    private static void deleteElement(Document doc) {
        NodeList employees = doc.getElementsByTagName("Employee");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Node genderNode = emp.getElementsByTagName("gender").item(0);
            emp.removeChild(genderNode);
        }
        
    }

    private static void updateElementValue(Document doc,String st0,String st1,String st2,String st3,String st4) throws Throwable {
    	
        NodeList employees = doc.getElementsByTagName("DrugType");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            Node DosageFormCd = emp.getElementsByTagName("DosageFormCd").item(0).getFirstChild();
            DosageFormCd.setNodeValue(st0);
            
            Node DosageFormType = emp.getElementsByTagName("DosageFormType").item(0).getFirstChild();
            DosageFormType.setNodeValue(st1);
            
            
            Node DrugDefaultSig = emp.getElementsByTagName("DrugDefaultSig").item(0).getFirstChild();
            DrugDefaultSig.setNodeValue(st2);
            

            Node DrugStrength = emp.getElementsByTagName("DrugStrength").item(0).getFirstChild();
            DrugStrength.setNodeValue(st3);

            Node DrugStrengthUOM = emp.getElementsByTagName("DrugStrengthUOM").item(0).getFirstChild();
            DrugStrengthUOM.setNodeValue(st4);
          
            Node GPI = emp.getElementsByTagName("GPI").item(0).getFirstChild();
            GPI.setNodeValue("crocin6");
            
            Node NDC = emp.getElementsByTagName("NDC").item(0).getFirstChild();
            NDC.setNodeValue("crocin7");
            
            
            Node RouteOfAdminCodedVal = emp.getElementsByTagName("RouteOfAdminCodedVal").item(0).getFirstChild();
            RouteOfAdminCodedVal.setNodeValue("crocin8");
            
            Node SingleActiveIngredientInd = emp.getElementsByTagName("SingleActiveIngredientInd").item(0).getFirstChild();
            SingleActiveIngredientInd.setNodeValue("crocin9");
            
            Node DrugClassType = emp.getElementsByTagName("DrugClassType").item(0).getFirstChild();
            DrugClassType.setNodeValue("crocin9");
       
	       
          
        }
    }

    private static void updateAttributeValue(Document doc) {
        NodeList employees = doc.getElementsByTagName("Employee");
        Element emp = null;
        //loop for each employee
        for(int i=0; i<employees.getLength();i++){
            emp = (Element) employees.item(i);
            String gender = emp.getElementsByTagName("gender").item(0).getFirstChild().getNodeValue();
            if(gender.equalsIgnoreCase("male")){
                //prefix id attribute with M
                emp.setAttribute("id", "M"+emp.getAttribute("id"));
            }else{
                //prefix id attribute with F
                emp.setAttribute("id", "F"+emp.getAttribute("id"));
            }
        }
    }

}
