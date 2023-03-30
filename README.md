# STCTV Test Automation

## Description
A simple test automation framework build with Java, TestNG, Selenium WebDriver and allure.

## Requirements:
- JDK 11
- Eclipse IDE
- Eclipse TestNG Plugin: https://testng.org/doc/eclipse.html
- Maven
- TestNG 7.5.0
- Selenium 4.1.3
- Log4j2
- Allure-reports

## Run Configuration

### Eclipse IDE TestNG Plugin
- Right-click on 'TestNG.xml' file
- Choose Run As -> TestNG Suite
- Generate allure report via cmd 'allure serve allure-results'

### Eclipse IDE Maven
- Right-click on project 'pom.xml' file
- Choose Run As -> Maven test
- Generate allure report via cmd 'allure serve allure-results'

### Maven
- Run command 'mvn clean test'
- Navigate to the project directory.
- Generate allure report via cmd 'allure serve allure-results'



