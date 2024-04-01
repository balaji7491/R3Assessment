# Exchange API Test Validation :- This project contains automated tests for validating the Exchange API. 

## The tests verify various aspects of the API such as endpoint functionality, JSON schema compliance, response times, and currency rate ranges. 
## Getting Started these instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
## Prerequisites: What things you need to install the software and how to install them:  Java [17] - RestAssured [5.4.0] - Maven - TestNG - Cucumber - [For other dependencies PLEASE refer pom.xml for easy installation].

## Installing
A step-by-step series of examples that tell you how to get a development environment running:
## 1.	Clone the repository:
git clone [https://github.com/balaji7491/R3Assessment.git] 
## 2.	Navigate to the project directory:
cd [R3Assessment] 
## 3.	Install dependencies:
mvn install 
## Running the tests
To run the tests, use the following command:
mvn test

## Test Scenarios
The tests cover the following scenarios:
•	Verify USD Endpoint: Checks if the USD endpoint is functioning correctly.

•	Status Code Validation: Ensures that the API returns the expected success status code.

•	Response Time Check: Confirms that the API response time is within the acceptable range.

•	Currency Rate Validation: Verifies that the currency rate for 'AED' falls within the specified range.

Each test scenario is documented with Gherkin syntax in the exchangeBaseUSD.feature file for clarity and BDD-style testing.

## Built With
•	Java - Programming Language, Version: 17
•	RestAssured - Used for API testing 
•	TestNG - Testing framework
•	Maven - Dependency Management
## Authors
•	Balaji Sambamoorthy - Lead Engineer - Balaji7491
## License
This project is licensed under the [MIT Licence] - see the LICENSE.md file for details
## Acknowledgments
•	Thanks to the creators of the Exchange API for providing a robust platform for financial data. 
