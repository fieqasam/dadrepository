package Exercise4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * This program demonstrate writing data as byte using DataOutputStream.
 * 
 * @author Nurul Afiqah
 */
public class WriteByteDemoRainfall {

	public static void main(String[] args) throws IOException {
		// 1.Declaring of target storage
		
		String targetStorage = "outByteRainfallDemo3.txt";
	
		//Data Declaration
		int stationID[]= {2321006, 2222002, 2324033, 2225044, 2222007, 2221008};
		String stationName[]= {"Ladang Lendu", "Durian Tunggal", "Hospital Jasin", "Sg.Chohong", "Cheng D/S", "Pusat Pertanian Sg Udang"};
		String districtName[]= {"Alor Gajah", "Alor Gajah", "Jasin", "Jasin", "Melaka Tengah", "Melaka Tengah"};
		double day1[] = {115.0, 94.0, 48.0, 43.0, 145.0, 94.0};
		double day2[] = {1.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		double day3[] = {2.0, 3.0, 0.0, 0.0, 0.0, 1.0};
		double day4[] = {1.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		double day5[] = {1.0, 0.0, 7.0, 0.0, 0.0, 1.0};
		double day6[] = {0.0, 0.0, 8.0, 5.0, 0.0, 0.0};
	
		//2.create stream to read data 
		DataOutputStream rainfall = new DataOutputStream(new FileOutputStream(targetStorage));
		
		//process data
		for(int index=0; index < stationName.length; index++) {
			
			//3.write data into data stream
			rainfall.writeInt(stationID[index]);
			rainfall.writeUTF(stationName[index]);
			rainfall.writeUTF(districtName[index]);
			rainfall.writeDouble(day1[index]);
			rainfall.writeDouble(day2[index]);
			rainfall.writeDouble(day3[index]);
			rainfall.writeDouble(day4[index]);
			rainfall.writeDouble(day5[index]);
			rainfall.writeDouble(day6[index]);
			
			//4.Flush for each writing
			rainfall.flush();
			
		}
		//5.Close stream
		rainfall.close();
		
		
		//Indicate the end of the program could be successful
		System.out.println("End of program. Check out the "+targetStorage);
	}
		
}
