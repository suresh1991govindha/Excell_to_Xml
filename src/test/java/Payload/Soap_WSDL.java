package Payload;

public class Soap_WSDL {

	
	public static String Drug()
	{
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://schema.walgreens.com/icp/pharm/pharmsigservices/v1\">\r\n" + 
				"   <soapenv:Header/>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <v1:PharmSIGServiceWrapperRequest>\r\n" + 
				"         <OriginalParsedSIGToken>\r\n" + 
				"            <MiscNotes>937ea49031ff416bb7725070aaf343d7</MiscNotes>\r\n" + 
				"         </OriginalParsedSIGToken>\r\n" + 
				"         <TransmittedSIG>1 tab(s) once a week</TransmittedSIG>\r\n" + 
				"         <DrugType>\r\n" + 
				"            <DosageFormCd>TABS</DosageFormCd>\r\n" + 
				"            <DosageFormType>tablet</DosageFormType>\r\n" + 
				"            <DrugDefaultSig>TK 1 T PO ONCE A WEEK, UTD</DrugDefaultSig>\r\n" + 
				"	            <DrugStrength>35</DrugStrength>\r\n" + 
				"            <DrugStrengthUOM>MG</DrugStrengthUOM>\r\n" + 
				"            <GPI>30042065100330</GPI>\r\n" + 
				"            <NDC>00591207539</NDC>\r\n" + 
				"            <RouteOfAdminCodedVal>OR</RouteOfAdminCodedVal>\r\n" + 
				"            <SingleActiveIngredientInd>S</SingleActiveIngredientInd>\r\n" + 
				"            <DrugClassType>RX</DrugClassType>\r\n" + 
				"         </DrugType>\r\n" + 
				"         <PatientType>\r\n" + 
				"            <Age>68</Age>\r\n" + 
				"            <FirstName>PATIENT</FirstName>\r\n" + 
				"         </PatientType>\r\n" + 
				"      </v1:PharmSIGServiceWrapperRequest>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Soap_WSDL.Drug());
	}
}
