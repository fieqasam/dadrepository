package Exercise3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate daily rainfall in Melaka for 6 days using DataOutputStream.
 * 
 * The data represent dailyRainfallData for 6 days daily rainfall in several states of Melaka.
 * 
 * @author Nurul Afiqah
 *
 */
public class Exe3DataGenerator {
	
	public static void main(String[] args) {
		
		//1.Declare the output file
		String outFile = "dailyRainfallData2.txt";
		
		//Data Declaration
		String station[]= {"Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6"};
		double dailyRainfallData[]= {145.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		try {
			//2.Create stream to read data
			DataOutputStream datarainfall = new DataOutputStream(new FileOutputStream(outFile));
			
			//process data
			for(int index=0; index< station.length; index++ ) {
				//3.write data into data stream
				datarainfall.writeUTF(station[index]);
				datarainfall.writeDouble(dailyRainfallData[index]);
				
				//4.Flush for each writing
				datarainfall.flush();
					
			}
			//5.close stream
			datarainfall.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//Indicate the end of the program-could be successful
		System.out.println("End of program. Check out the "+outFile);
		
	
	}

}
