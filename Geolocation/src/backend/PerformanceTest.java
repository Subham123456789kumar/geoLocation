package backend;



/**
 * The PerformanceTest class provides a method to run a performance test on the CountryLocator class.
 */

public class PerformanceTest{
	
	
	/**
     * Runs a performance test on the CountryLocator class by simulating 100 requests per second.
     *
     * @param locator the CountryLocator instance to test
     * @param latitude the latitude to test
     * @param longitude the longitude to test
     */
	

    public void runTest(CountryLocator locator, double latitude, double longitude) {
        // Number of requests to simulate
        int requestsPerSecond = 100;
        
        // Total time taken for all requests

        long totalTime = 0;

        
        // Loop through the number of requests

        for (int i = 0; i < requestsPerSecond; i++) {
        	
            // Start time of the request

        	
            long startTime = System.currentTimeMillis();
            
            // Perform the request

            locator.getCountryCode(latitude, longitude);
            
            // End time of the request

            long endTime = System.currentTimeMillis();
            
            // Calculate the time taken for the request and add it to the total time


            totalTime += (endTime - startTime);
        }

        
        // Calculate the average time taken per request

        long averageTime = totalTime / requestsPerSecond;
        
        
        // Print the average execution time per request

        
        System.out.println("Average execution time per request: " + averageTime + " milliseconds");
    }
}
