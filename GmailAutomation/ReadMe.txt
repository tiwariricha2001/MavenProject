1. There are two Test Classes that run successfully : AmazonCartTest and AmazonSignInTest
   Their corresponding Pages are: AmazonHomePage, AmazonProductPage, AmazonSignInPage, 
   and UpdateLocationPage
   
2. testng file is in : testrunner --> testng.xml

3. Since firefox and IE browsers are slower than Chrome the tests fail when Running
   through tetsng. But in logs you can check that The test classes run successfully for Chrome
   (very first logs).
   
4. The EXTENT REPORT file is named "TestReport.html"

5. To view Extent report run The test classes (AmazonCartTest and AmazonSignInTest) directly
   and not through testng. 

6. Testdata file is name: "Config.properties"
   The methods to read this file is defined in "ReadConfigFile"
   
7. Logs are in: logs --> logs.log

8. Screenshot image (separately) is in : screenshots --> searchAndAddToCart.png

 
