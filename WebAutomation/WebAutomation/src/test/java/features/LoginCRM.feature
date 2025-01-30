Feature: CRM

@smoke
  Scenario: CRM Login
    Given User is on CRM Login Page
    And Validate header of the login page "Login"
    Then user enters us "Admin" and pwd "admin123"
    And click on Login
    Then Validate home page
    And Logout from application and validate user is on login page "Login"
 
    
    
