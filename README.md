# geoLocation
* CountryLocator

CountryLocator is a Java application that determines the country code (ISO 3166-1 alpha-2 format) for given latitude and longitude coordinates. The application interacts with a MySQL database to fetch the country details and includes functionality for unit and performance testing.

** Table of Contents

 1.[Overview]
 2.[Setup]
 3.[Database Setup]
 4.[Application Setup]
 5.[Usage]
 6.[Running the Application]
 7.[Running Tests]
 8.[Performance Testing]
 9.[Technologies Used]

** Overview

The `CountryLocator` application provides the following functionality:
1. Accepts latitude and longitude as input and returns the corresponding country code.
2. Connects to a MySQL database to retrieve country boundary information.
3. Includes unit tests to verify the functionality of the `CountryLocator` class.
4. Provides a performance test to simulate 100 requests per second and measure the average response time.

** Setup

** Database Setup

1. Install MySQL and create a database named `GeoLocation`.
2. Create a table `CountryBoundaries` with the following schema:
    sql
	
    CREATE TABLE CountryBoundaries (
        id INT AUTO_INCREMENT PRIMARY KEY,
        country_code VARCHAR(2) NOT NULL,
        min_lat DOUBLE NOT NULL,
        max_lat DOUBLE NOT NULL,
        min_lon DOUBLE NOT NULL,
        max_lon DOUBLE NOT NULL
    );
    
3. Populate the table with country boundary data.

*** Application Setup

1. Download and install JDK 17.
2. Ensure the MySQL Connector/ (JAR file) is added to your project's classpath. You can download it from the [MySQL website](https://dev.mysql.com/downloads/connector/j/).
3. Copy the Java source files (`CountryLocator.java`, `CountryLocatorTest.java`, `PerformanceTest.java`) into your project directory.

** Usage

*** Running the Application

1. Compile the Java source files:
    
    javac backend/CountryLocator.java backend/PerformanceTest.java
    
2. Run the `CountryLocator` class:
    
    java backend.CountryLocator
    
3. Enter the latitude and longitude when prompted.
4. The application will display the corresponding country code or a message indicating that no country was found.

*** Running Tests

1. Ensure JUnit 4 is added to your project's classpath.
2. Compile and run the `CountryLocatorTest` class:


3. The tests will verify the functionality of the `getCountryCode` method and its exception handling.

*** Performance Testing

1. Compile and run the `PerformanceTest` class to simulate 100 requests per second and measure the average response time:
    
    javac backend/PerformanceTest.java
    java backend.PerformanceTest
   

** Technologies Used

- Java (JDK 17)
- MySQL
- JUnit 4.13.2
- MySQL Connector/Jar 8.0.11

