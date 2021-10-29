
package Exercise3;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*
 * This program demonstrate reading 6-days rainfall data for selected station.
 * 
 * it is by using DataInpurStream
 * 
 * The program calculates the average daily rainfall and display it on the console.
 * 
 * @author Nurul Afiqah
 */
public class Exe3DataReader {

	public static void main(String[] args) {
		// 1.Declare the output file
				String sourceFile = "dailyRainfallData2.txt";
				System.out.println("Reading data from "+sourceFile+ "\n");
				
				try {
					//2.create stream to read data
					DataInputStream readData = new DataInputStream(new FileInputStream(sourceFile));
					
					//variable for processing data
					double  dailyRainfallData=0;
					double totalDailyRainfallData=0;
					int noOfRecords = 0;
					String station ="";
					
					// 3. Process data until end-of-file
					while(readData.available() > 0) {
						
						for(int index=0; index <= station.length(); index++) {
							
							//Read data
							station = readData.readUTF();
							dailyRainfallData = readData.readDouble();
							System.out.println( station + " Cheng(Taman Merdeka)"+ "\t" + dailyRainfallData);
							
							//calculate total dailyRainfallData
							totalDailyRainfallData += dailyRainfallData;
							noOfRecords++;	
						}
						
						
					}
					//4.Close stream
					readData.close();
					
					//calculate average dailyRainfallData
					double averageDailyRainfallData = totalDailyRainfallData /  noOfRecords;
					String formattedAverage = String.format("%.1f", averageDailyRainfallData);
					System.out.print("\nAverage  for " + noOfRecords 
							+ " days daily rainfall from selected station is : " + formattedAverage + "%");
					
				}
				catch(Exception e) {
					
					e.printStackTrace();
					
				}
				
				// Indicate end of program - Could be successful
				System.out.println("\nEnd of program.");
				
			}
	}

