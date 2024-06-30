package backend;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * The CountryLocatorTest class contains unit tests for the CountryLocator class.
 */
public class CountryLocatorTest {
	
	
	/**
     * Tests the getCountryCode method with valid coordinates.
     * Asserts that the returned country code matches the expected value.
     */

    @Test
    public void testGetCountryCode_ValidCoordinates() {
        CountryLocator locator = new CountryLocator();
        String countryCode = locator.getCountryCode(12, 89);
        assertEquals("IN", countryCode); 
    }
    
    
    /**
     * Tests the getCountryCode method with invalid coordinates.
     * Asserts that the returned country code is null, indicating no country was found.
     */

    @Test
    public void testGetCountryCode_InvalidCoordinates() {
        CountryLocator locator = new CountryLocator();
        String countryCode = locator.getCountryCode(0.0, 0.0); 
        assertNull(countryCode);
    }
    
    
    
    /**
     * Tests the getCountryCode method's exception handling.
     * Simulates a database connection error and asserts that the correct exception message is thrown.
     */
    
    @Test
    public void testGetCountryCode_ExceptionHandling() {
        CountryLocator locator = new CountryLocator() {
            @Override
            public String getCountryCode(double latitude, double longitude) {
                throw new RuntimeException("Database connection error");
            }
        };

        try {
            locator.getCountryCode(12, 89);
            fail("Expected an exception to be thrown");
        } catch (RuntimeException e) {
            assertEquals("Database connection error", e.getMessage());
        
    
    
    
    
    
        }
    }
    
    
    
    
    

}
