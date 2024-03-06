# Automation_MavenProject_V001

Project Name: Automating the Application Tendable Tech Challenge.
Description: Testing the functionality of the application and validating and verifying the top-level menus etc... 
Features:
                  1.    Automation of web testing using Selenium WebDriver.
                  2.    Programming language used Java
                  3.   TestNG for integration for organizing and executing test cases.
                  4.  Reporting (TestNG reports, custom reports).
                  5.   TestNg for it Support parallel test execution.
Setup Instructions:
                      Java Development Kit (JDK), TestNG, Selenium WebDriver, and any required dependencies, Plugins.
Usage:
                      Designed and implemented TestNg using java with selenium WebDriver based on the POC (Prof of concept) and based on the Maven build tool concept.
In the script we have POM.xml file and TestNg for Parallel execution. TestNG for it supports the reach set of annotations based on the annotation we can control our execution flow and easy to debug the failed test scripts. TestNg we can create in terms of Class level, Package level, Method level, TestNg test level but in the script, Test Ng created class level so that Launch and navigation provided @BeforeClass and Close and quit application provided @AfterClass annotations and order of execution specified Priority. TestNg by default executes less priority. 
TestNG is a testing framework designed for Java.
It provides annotations to define test methods, dependencies, groups, and more.
TestNG features like parallel test execution, data-driven testing, and easy configuration through XML files.
Setting Up TestNG:
Add TestNG dependency to your project using build tools like Maven build tool we get POM.xml file based on the project requirements we can use required dependencies and plugins and some tools for reportings.
Configure TestNG by creating testng.xml file to specify test suites, test cases, and configurations.
Creating Test Classes:
We can write test classes using Java and annotate test methods with TestNG annotations like @Test.
TestNG annotations such as @BeforeClass, @Test, @DataProvider, @AfterClass etc., for setup and teardown operations.
TestNG Annotations and Sequence of execution:
   @BeforeSuite, @BeforeTest, @Beforeclass, @BeforeMethod, @Test, @AfterMethod, @Afterclass, @AfterTest,
@AfterSuite
TestNG Asserts:
Using TestNG assertion methods like assertEquals(), assertTrue(), assertFalse(). To validate expected outcomes.
Assertions help in verifying that the application behaves as expected during test execution.

Running Tests:
We can execute tests using TestNG test runner either from IDE or command line.
TestNG supports running tests in parallel to save execution time.
Parameterized Tests:
`We can perform data-driven testing using TestNG's @DataProvider annotation to supply test data to test methods.
Data providers can be arrays, objects, or external data sources like Excel files or databases.
Grouping Tests:
Group of TestNg It’s depends on the specific testcases belongs to specific functionality. Group related test methods using TestNG's @Test annotation with groups attribute.
We can execute specific groups of tests or exclude certain groups using TestNG XML configuration.
Reporting:
TestNG generates detailed HTML reports with test results, including pass/fail status, execution time, and logs.
Customize reports using listeners and reporters to integrate with other reporting tools or frameworks.
Parallel Execution:
TestNG allows running tests in parallel to speed up test execution.
Configure parallel execution at different levels such as suite, test, class, or method.
Project Structure:
          Project-name (Automation_MavenProject_V001)
          ├── src/test/java
                └──  Package(com.assessment)
                └──   Application_Tendebale.java 
          ├── JRE System Library(It all our java libraries)
          ├── Maven Dependencies (It contains all Jar files)
          ├── src
                └── target folder
          ├── test-output(Default test deports)
                └──  Bug report.docx(Creating bug issue if not expected results)
                └──  testng.xml.
                └──  pom.xml.
                └── README.md
                   
Reporting:
Default HTML Reports:
By default, TestNG generates HTML reports in the "test-output" directory of the project.
These reports include details about test cases, suites, groups, methods, and their status (pass/fail/skip).
we can view these reports using any web browser.
      Customizing Reports:
       TestNG allows to customize the default HTML reports or generate custom reports.
      Custom Reporters:
        TestNG allows to create custom reporters to generate reports in different formats such as XML, JSON, PDF, etc.
      Third-Party Reporters:
         Also we can integrate TestNG with third-party reporting tools like Extent Reports, Allure reporting if required.  
Continuous Integration (CI) Integration:
We can use TestNG in a Continuous Integration (CI) environment like Jenkins, configure Jenkins to publish TestNG reports as part of the build process.
