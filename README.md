# SpriteCloudAssignment

Given : 

1. Environment and specs:
  ○ http://www.uitestingplayground.com/ (UI)
  ○ https://petstore.swagger.io/ (API)
2. Required scripting language: Java
3. Required testing tool: Selenium, Cucumber, Maven, TestNg, RestAssured
4. CI platform: Jenkins
5. You have an account on Calliope.pro : Yes Created

When
1. You have listed the most important scenarios to automate (minimal 3 API and 3 Web)

-->API Automation
  a) Verify user is able to create new user
  b) Verify user is able to get user details1
  c) Verify user is able to update user details
  d) Verify user is able to delete user details
  
 --> Web Automation 
    a) Verify user is able to handle dynamic id 
    b) Verify user is able to handle dyanamic web table
    c) Verify user is able to handle client side delay.
    
2. You have automated the scenarios

--> Yes Automatrd

3. You managed to run the tests in a CI/CD environment

--> Yes Jenkins and configured through github

4. You share the codebase through GitHub or GitLab

--> Yes

5. You add a results folder to the repository, including a result report (HTML,json,xml,etc)

--> Yes all three formats are available 

6. Manage to upload the test results to Calliope.pro and share a link to the results.

--> Yes
  Suite level report --> https://app.calliope.pro/reports/165509/public/ba94c182-3cc0-4b5a-8412-81c2840ab590
  
  Web report --> https://app.calliope.pro/reports/165504/public/0796a330-91cf-408d-8f7c-39ec48520c23
  
7. The codebase has a readme.md file covering the following:
-->  Yes

a. How to run the tests locally;

--> You can run through multiple ways:
    1) Run through Run.bat file (Provided Maven config is done at ur end)
    2) Run through testng.xml
    3) Run through seperal runner file one for web and other for API
    4) Run through cucumber feature file

b. How to run the test in a CI/CD pipeline

  --> 1)Created new project in jenkins
      2)Configured with github link
      3)Click build now
      4)Check logs now
  
c. Has a link to the results in Calliope.pro;

--> Yes
 Suite level report --> https://app.calliope.pro/reports/165509/public/ba94c182-3cc0-4b5a-8412-81c2840ab590
  
  Web report --> https://app.calliope.pro/reports/165504/public/0796a330-91cf-408d-8f7c-39ec48520c23

d. Describe one improvement point and one new feature for the Calliope.pro platform;

-->1) Error while uploading html reports
   2) Converting html files to xml and json in the platform itself

e. What you used to select the scenarios, what was your approach?;
--> For API:
    I used RestAssured,Java,testng,and perform CRUD Operation
    
    For WEB:
    I used the most important scenarios you should know while automating any application
    like how to handle dynamic id, dyanmic webtable and client side delay using
    selenium, Cucumber, testng, maven, java
    
f. Why are they the most important;

--> For API:
    The important thing in api automation is user should be able to automation CRUD Operations
    thats the reason i choosed CRUD 
 --> For WEB:
    The main thing user should know while automating is how to handle dynamic element, webtable
    and waits.
    
g. What could be the next steps to your project;
--> Implementing POJO Classes for API
    ExtentReports
    Add PDFReports
    Creating reusable methods
    Seperating stepsdef and action class
    
8. You nail the interviews!
