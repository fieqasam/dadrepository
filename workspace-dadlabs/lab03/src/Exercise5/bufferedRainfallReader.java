package Exercise5;

import java.io.BufferedReader;
import java.io.FileReader;

public class bufferedRainfallReader {
	
	/**
	 * This program demonstrate reading character-based data from a buffer using BufferedWriter.
	 * The data represents daily rainfall data for 6 days in several station of Melaka .
	 *
	 * The program calculates the average of 6 days daily rainfall of selected station in Melaka.
	 * 
	 * @author Nurul Afiqah
	 *
	 */	

	public static void main(String[] args) {
		// 1. Declare the output file
		String sourceFile = "exercise5.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		System.out.println("Daily of Rainfall Data From Selected Station For Each District in Melaka");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		try {
			// 2. Create stream to read data
			BufferedReader buffRead = new BufferedReader(new FileReader(sourceFile));
			
			// Variables for processing character-based data
			
			String strRainfall = "";
			
	
			// 3.  read the file until it has reached the end of file
            while ((strRainfall = buffRead.readLine()) != null) {
            	
            	// strRainfall reads the current line and the Java readLine function buffRead.readLine() returns a string
				
				System.out.println(strRainfall);
            }
           
          //4. close stream
			buffRead.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		// Indicate end of program - Could be successful
		System.out.println("End of program.");	

	}

}
