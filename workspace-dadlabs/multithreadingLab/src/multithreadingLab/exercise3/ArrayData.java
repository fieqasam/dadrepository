package multithreadingLab.exercise3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represent print data in array  in random order
 * @author nurul afiqah
 * 
 */

public class ArrayData  implements Runnable{
	/**
	 * This method print data as extraction increase for every repetition
	 * @param threadName - name of thread
	 */

	String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
	//number of repetition
	int repeat= 10;
	
	//get the size of array
	int dataSize = data.length;
	
	// new size for new array
	int newSize = dataSize*repeat;
	
	//new array to store the element
	String[] result = new String[newSize];
	
	public void printArray () {
		String text = "";
		for(int i=0; i<repeat; i ++) {
			result[i] = data[i%dataSize];
			text = text + " "+ result[i];
			System.out.println(text);
		}
	
	} 
	
	public void randomData(String currentThread) {
		try {
			
			String[] data = {"It", "is", "recommended", "to", "use", "calendar", "class"};
			
			List<String> list = Arrays.asList(data);
			Collections.shuffle(list);
			list.toArray(data);
			for(String element:data) {
							
			System.out.println(currentThread + "->"+element);
			
			//Suspend the current thread for 5 milliseconds
			Thread.sleep(5000);
							
			}
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public void run() {
		//Get current thread
		Thread currentThread = Thread.currentThread();
		
		//Execute task
		printArray();
		randomData(currentThread.getName());
		
	}
	
}