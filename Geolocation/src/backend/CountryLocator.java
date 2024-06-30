package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
* The CountryLocator class provides a method to get the country code for given latitude and longitude.
*/



public class CountryLocator {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/GeoLocation?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "komal123"; 
    
    
    
    
    
    /**
     * Gets the country code for the given latitude and longitude.
     *
     * @param latitude the latitude of the location
     * @param longitude the longitude of the location
     * @return the country code in ISO 3166-1 alpha-2 format, or null if not found
     */
    

    public String getCountryCode(double latitude, double longitude) {
        String countryCode = null;
        String query = "SELECT country_code FROM CountryBoundaries WHERE ? BETWEEN min_lat AND max_lat AND ? BETWEEN min_lon AND max_lon";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, latitude);
            statement.setDouble(2, longitude);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    countryCode = resultSet.getString("country_code");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countryCode;
    }
    
    
    /**
     * The main method to run the CountryLocator program.
     *
     * @param args command-line arguments
     */

    public static void main(String[] args) {
        CountryLocator locator = new CountryLocator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter latitude:");
        double latitude = scanner.nextDouble();

        System.out.println("Enter longitude:");
        double longitude = scanner.nextDouble();

        String countryCode = locator.getCountryCode(latitude, longitude);
        if (countryCode != null && !countryCode.isEmpty()) {
            System.out.println("Country code: " + countryCode);
        } else {
            System.out.println("No country found for the given coordinates.");
        }

        scanner.close();

        PerformanceTest performanceTest = new PerformanceTest();
        performanceTest.runTest(locator, latitude, longitude);
    }
}
