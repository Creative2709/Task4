Feature: Linkedin Login

 Scenario: Linkedin user login with valid credentials
    
Given User is on login page with valid credentials from Excel
When User enters username and password
Then User clicks the login button
Then User logged in
Then browser close