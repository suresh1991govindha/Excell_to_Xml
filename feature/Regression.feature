Feature: This feature is to check POST API
Scenario Outline: Check if user is able to submit GET API request

    Given I want to execute service <serviceName>
    When I submit the GET request as per the data in Excel Worksheet <EWorksheet>
    And I validate status code
    And I validate mandatory tag in response from Excel Worksheet <EWorksheet>
    And I validate response content
    And I validate tag values in response from Excel Worksheet <EWorksheet>
    And I validate header parameter in response\
    
 Examples:
| serviceName           | EWorksheet |
| getClientDetails      |  0         |
| getClientDetails      |  1         |

@tag1
  Scenario: Check if user is able to submit POST service

   Given I want to execute service 
    When I the POST request as per the data in Excel Worksheet 
    And I validate status code
    And I validate mandatory tag in response from Excel Worksheet 
    And I validate response content
    And I validate header parameter in response

