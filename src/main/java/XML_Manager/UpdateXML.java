package XML_Manager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UpdateXML {

	  public static void updateElementValue(Document doc,String st0,String st1,String st2,String st3,String st4,String st5,String st6,String st7,String st8,String st9) throws Throwable {
	    	
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
	            GPI.setNodeValue(st5);
	            
	            Node NDC = emp.getElementsByTagName("NDC").item(0).getFirstChild();
	            NDC.setNodeValue(st6);
	            
	            
	            Node RouteOfAdminCodedVal = emp.getElementsByTagName("RouteOfAdminCodedVal").item(0).getFirstChild();
	            RouteOfAdminCodedVal.setNodeValue(st7);
	            
	            Node SingleActiveIngredientInd = emp.getElementsByTagName("SingleActiveIngredientInd").item(0).getFirstChild();
	            SingleActiveIngredientInd.setNodeValue(st8);
	            
	            Node DrugClassType = emp.getElementsByTagName("DrugClassType").item(0).getFirstChild();
	            DrugClassType.setNodeValue(st9);
	       
		       
	          
	        }
	    }

}
