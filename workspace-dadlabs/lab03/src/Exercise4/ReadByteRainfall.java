package Exercise4;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * This program demonstrate reading data from a file using FileInputStream
 *
 * @author Nurul Afiqah
 */

public class ReadByteRainfall {

	public static void main(String[] args) {
		// 1. Declaration of input source
		String rainfallData = "outByteRainfallDemo3.txt";

		System.out.println("Reading data from "+rainfallData+ "\n");

		System.out.println("Daily of Rainfall Data From Selected Station For Each District in Melaka");
		
		System.out.println("------------------------------------------------------------------------------------------------");
		try {
			// 2. Create stream to read data
			DataInputStream readRainfall = new DataInputStream(new FileInputStream(rainfallData));

			// variable for processing data
			int stationID = 0;
			String stationName = "";
			String districtName = "";
			double day1=0;
			double day2=0;
			double day3=0;
			double day4=0;
			double day5=0;
			double day6=0;
			
			double totalRainfallStation=0;
			int noOfRecords=0;
			
			// 3. Process data until end-of-file
			while(readRainfall.available()> 0) {
					
					//Read data
					stationID = readRainfall.readInt();
					stationName = readRainfall.readUTF();
					districtName = readRainfall.readUTF();
					day1 = readRainfall.readDouble();
					day2 = readRainfall.readDouble();
					day3 = readRainfall.readDouble();
					day4 = readRainfall.readDouble();
					day5 = readRainfall.readDouble();
					day6 = readRainfall.readDouble();
					
					//calculate total dailyRainfallData for each station
					totalRainfallStation = day1 + day2 + day3 + day4 + day5 + day6;
					noOfRecords++;	
					
					System.out.println(stationID +"\t\t"+ stationName+ "\t\t"+ districtName+ "\t"+ day1+ "\t" +day2+ "\t"
							+day3 +"\t" +day4 +"\t"+day5 +"\t"+ day6+ "\t"+ "\n");
				
					
					//calculate average dailyRainfallData
					double averageRainfallStation = totalRainfallStation / 6;
					String formattedAverage = String.format("%.1f", averageRainfallStation);

					System.out.println("Total daily of rainfall for 6 days  of the selected station is "+totalRainfallStation);
					System.out.println("The average rainfall of the selected station is "+formattedAverage);
					System.out.println("------------------------------------------------------------------------------------------------");
					
				}

			//4. close stream
			readRainfall.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// Indicate end of program - Could be successful
					System.out.println("\nEnd of program.");
	}

}
