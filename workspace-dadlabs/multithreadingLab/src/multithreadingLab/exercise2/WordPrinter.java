package multithreadingLab.exercise2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrate the task to print data
 * 
 * @author Nurul Afiqah
 *
 */

public class WordPrinter implements Runnable{
	
	/**
	 * This method prints list of array and numbers
	 * 
	 * @param currentThread - name of current Thread
	 * 
	 */
	
	//array created 
	//display data in array on order
	public void printData (String currentThread) {
			
			try {
				
				String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
				//number of repetition
				int repeat= 10;
				
				//get the size of array
				int dataSize = data.length;
				
				// new size for new array
				int newSize = dataSize*repeat;
				
				//new array to store the element
				String[] result = new String[newSize];
				
					String text = "";
					for(int i=0; i<repeat; i ++) {
						result[i] = data[i%dataSize];
						text = text + " "+ result[i];
						System.out.println(currentThread + "->"+ text);
						
					}
				
				
				
				
			}
			
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
		
	@Override
	public void run() {
		
		//Get current thread
		Thread currentThread = Thread.currentThread();
		
		//Execute task
		printData(currentThread.getName());
		
	}

}
