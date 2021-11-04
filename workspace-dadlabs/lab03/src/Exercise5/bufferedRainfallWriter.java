package Exercise5;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * This program demonstrate writing character-based data into a buffer using BufferedWriter.
 * The data represents daily rainfall data in several selected station of Melaka
 * 
 * @author Nurul Afiqah 
 *
 */

public class bufferedRainfallWriter {

	public static void main(String[] args) {
		// 1.Declaring of target storage
		String targetStorage = "exercise5.txt";
	
		//Data Declaration
		String stationID []= {"2321006", "2222002", "2324033", "2225044", "2222007", "2221008"};
		String stationName[]= {"Ladang Lendu", "Durian Tunggal", "Hospital Jasin", "Sg.Chohong", "Cheng D/S", "Pusat Pertanian Sg Udang"};
		String districtName[]= {"Alor Gajah", "Alor Gajah", "Jasin", "Jasin", "Melaka Tengah", "Melaka Tengah"};
		double day1[] = {115.0, 94.0, 48.0, 43.0, 145.0, 94.0};
		double day2[] = {1.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		double day3[] = {2.0, 3.0, 0.0, 0.0, 0.0, 1.0};
		double day4[] = {1.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		double day5[] = {1.0, 0.0, 7.0, 0.0, 0.0, 1.0};
		double day6[] = {0.0, 0.0, 8.0, 5.0, 0.0, 0.0};
		
		double totalRainfallStation=0;
		int noOfRecords=0;
		
		try {
			
			//2. create stream to read data
			BufferedWriter bfWriter = new BufferedWriter(new FileWriter(targetStorage));
			
			//process data
			for(int index=0; index < stationName.length; index++) {
				
				//3. Write data into stream
				
				bfWriter.write(stationID[index]+"\t");
				bfWriter.write(stationName[index]+"\t");
				bfWriter.write(districtName[index]+"\t");
				bfWriter.write(String.valueOf(day1[index])+"\t");
				bfWriter.write(String.valueOf(day2[index])+"\t");
				bfWriter.write(String.valueOf(day3[index])+"\t");
				bfWriter.write(String.valueOf(day4[index])+"\t");
				bfWriter.write(String.valueOf(day5[index])+"\t");
				bfWriter.write(String.valueOf(day6[index])+"\n");
				
				//calculate total dailyRainfallData for each station
				totalRainfallStation = day1[index]+day2[index]+day3[index]+day4[index]+day5[index]+day6[index];
				noOfRecords++;
				
				//calculate average dailyRainfallData
				double averageRainfallStation = totalRainfallStation / 6;
				String formattedAverage = String.format("%.1f", averageRainfallStation);
				
				bfWriter.write("Total daily of rainfall for 6 days  of the selected station is " +totalRainfallStation+"\n");
				bfWriter.write("The average rainfall of the selected station is "+formattedAverage+"\n");
				bfWriter.write("------------------------------------------------------------------------------------------------\n\n");
						
				//4. Flush for each writing
				bfWriter.flush();
			}
				
			// 5. Close stream
				bfWriter.close();
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + targetStorage); 

	}

	
}
