## Test Automation For Hotel Booking System

### Framework Design Approach
Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.

Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver but it is very optimized.Here we follow the concept of separation of Page Object Repository and Test Methods.

Additionally, with the help of PageFactory class, we use annotations @FindBy to find WebElement. We use initElements method to initialize web elements.

For UI Tests : Selenium-cucumber-Maven with PageFactory Design Pattern.

For API Tests : RestAssured with Junit

### Tools And Environment
1. IntelliJ IDEA 2016
2. Java-8
3. Maven-3.5.3
4. Enable cucumber-java plugin in IntelliJ
5. Git
6. Required driver versions (Chrome-v2.38 & Gecko-v0.20.1)
7. Required browsers (Chrome-v66.0 & Firefox-v60.0)
8. Windows 64bit

Configure JAVA_HOME and MAVEN_HOM in the Environmental Variables : Follow the setup instructions specified in here https://www.mkyong.com/maven/how-to-install-maven-in-windows/

### Test Architecture

```bash
  HotelBookingSystem
      |manualTestReports
      |  |ManualAcceptance.md
      |src/test/java
      |  |HelpersTests
      |  |  |ApiHelper
      |  |  |UiHelper
      |  |  |Utils
      |  |pageobjects
      |  |  |BookingHomePage
      |  |StepDefinitions
      |  |  |ApiStepDefinitions
      |  |  |Hooks
      |  |  |StepDefinitions
      |  |Dummy1
      |  |Dummy2
      |src/test/resources
      |  |Drivers
      |  |Features
      |  |  |HotelBooking.feature
      |  |  |ApiTests.feature
      |  |jsonFiles
      |  |  |Post.json
      |  |config.Properties
```


Steps to run the tests
--------------
Please make sure to have all the tools and libraries mentioned in the "Tools And Environment" section.

Step-1: Clone the repository from https://github.com/nirmalaC/HotelBookingSystem.git

Step-2: Use the following maven commands to run the tests.

```bash
Both UI and API tests can be executed by running the TestRunner

mvn clean -Dtest=RunTest test
```

```bash
To run the tests using cucumber options 

mvn test -Dcucumber.filter.tags="@ApiTests"

mvn test -Dcucumber.filter.tags="@FeatureAutomationTest"

```

```bash
To run the  test using cucumber options 

mvn test -Dcucumber.options="--tags @ApiTests"

mvn test -Dcucumber.options="--tags @FeatureAutomationTest"
```

### Cucumber Test Reports

##### UI Test Results

![alt text](https://user-images.githubusercontent.com/36641942/74015833-4da18680-4989-11ea-926f-f92376946b2b.png)

##### API Test Results

![alt text](https://user-images.githubusercontent.com/36641942/74015565-c8b66d00-4988-11ea-9006-6f51c1500c87.png)