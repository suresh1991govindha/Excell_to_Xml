package Config_manager;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	public class ConfigurationManager {

			
	public Properties ps;
		
		public ConfigurationManager() throws Throwable {
			//C:\Users\rockstr\eclipse-workspace\exeeell\config.properties
			try {
				File fs = new File(System.getProperty("user.dir")+"\\config.properties");
				FileInputStream fileInput = new FileInputStream(fs);
				ps = new Properties();
				ps.load(fileInput);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			
		}
		public String getEndpoint() {
			String endpoint = ps.getProperty("endpoint");
			if (endpoint==null) {
				System.out.println("endpoint is Not Found");
			}
			return endpoint;
		}
		public String getReportConfigPath(){
			 String reportConfigPath = ps.getProperty("reportConfigPath");
			 if(reportConfigPath!= null) return reportConfigPath;
			 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
			}
		public String getIn_XMLpath() {
			String xml_Input_path = ps.getProperty("xml_Input_path");
			if (xml_Input_path==null) {
				System.out.println("xml_Input_path is Not Found");
			}
			return xml_Input_path;
		}
		
		public String getOut_XMLpath() {
			String xml_Output_path = ps.getProperty("xml_Output_path");
			if (xml_Output_path==null) {
				System.out.println("xml_Output_path is Not Found");
			}
			return xml_Output_path;
		}
		public String getExcellpath() {
			String Excellpath = ps.getProperty("Excellpath");
			if (Excellpath==null) {
				System.out.println("Excellpath is Not Found");
			}
			return Excellpath;
		}
		
		public String getsheetname() {
			String sheetname = ps.getProperty("sheetname");
			if (sheetname==null) {
				System.out.println("sheetname is Not Found");
			}
			return sheetname;
		}
		public String getColumn0() {
			String Column0 = ps.getProperty("Column0");
			if (Column0==null) {
				System.out.println("Column0 is Not Found");
			}
			return Column0;
		}
		
		
		public String getColumn1() {
			String Column1 = ps.getProperty("Column1");
			if (Column1==null) {
				System.out.println("Column1 is Not Found");
			}
			return Column1;
		}
		
		
		public String getColumn2() {
			String Column2 = ps.getProperty("Column2");
			if (Column2==null) {
				System.out.println("Column2 is Not Found");
			}
			return Column2;
		}
		
		public String getColumn3() {
			String Column3 = ps.getProperty("Column3");
			if (Column3==null) {
				System.out.println("Column3 is Not Found");
			}
			return Column3;
		}
		
		public String getColumn4() {
			String Column4 = ps.getProperty("Column4");
			if (Column4==null) {
				System.out.println("Column4 is Not Found");
			}
			return Column4;
		}
		
		public String getColumn5() {
			String Column5 = ps.getProperty("Column5");
			if (Column5==null) {
				System.out.println("Column5 is Not Found");
			}
			return Column5;
		}
		public String getColumn6() {
			String Column6 = ps.getProperty("Column6");
			if (Column6==null) {
				System.out.println("Column6 is Not Found");
			}
			return Column6;
		}
		public String getColumn7() {
			String Column7 = ps.getProperty("Column7");
			if (Column7==null) {
				System.out.println("Column7 is Not Found");
			}
			return Column7;
		}
		public String getColumn8() {
			String Column8 = ps.getProperty("Column8");
			if (Column8==null) {
				System.out.println("Column8 is Not Found");
			}
			return Column8;
		}
		
		public String getColumn9() {
			String Column9 = ps.getProperty("Column9");
			if (Column9==null) {
				System.out.println("Column9 is Not Found");
			}
			return Column9;
		}
		
		public String getColumn10() {
			String Column10 = ps.getProperty("Column10");
			if (Column10==null) {
				System.out.println("Column10 is Not Found");
			}
			return Column10;
		}
		
		public String getColumn11() {
			String Column11 = ps.getProperty("Column11");
			if (Column11==null) {
				System.out.println("Column11 is Not Found");
			}
			return Column11;
		}		}

