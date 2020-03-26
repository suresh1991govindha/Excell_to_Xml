Feature: This feature is to check POST API
Scenario Outline: Check if user is able to submit GET API request

    Given I want to execute service <serviceName>
    When I submit the GET request as per the data in Excel Worksheet <EWorksheet>
    And I validate status code
    And I validate mandatory tag in response from Excel Worksheet <EWorksheet>
    And I validate response content
    And I validate tag values in response from Excel Worksheet <EWorksheet>
    And I validate header parameter in response
    
 Examples:
| serviceName           | EWorksheet |
| getClientDetails      |  0         |
| getClientDetails      |  1         |

@tag1
  Scenario: Check if user is able to submit POST service

   Given I want to execute service 
    When I the POST request as per the data in Excel Worksheet "xml"
   Then I validate status code "response code"
    And I validate mandatory tag in response from Excel Worksheet 
    And I validate response content
    And I validate header parameter in response

endpoint=https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx?WSDL
Request_XML=C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\Request_XML\\
Response_XML=C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\Response_XML\\
Excellpath=C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\input_Excell\\test data.xlsx
in_XMLpath=C:\\Users\\rockstr\\eclipse-workspace\\exeeell\\src\\test\\resource\\input_XML\\ERx_request.xml
sheetname=testData
Column0=STORE_NBR
Column1=RX_NBR
Column2=PAT_ID
Column3=DRUG_ID
Column4=DRUG_CLASS
Column5=DRUG_NON
Column6=DRUG_SUB_CD
Column7=PBR_ID
Column8=DRUG_NON_SYSTEM_CD
Column9=PLAN_ID
Column10=PLAN_COPAY_AMT


