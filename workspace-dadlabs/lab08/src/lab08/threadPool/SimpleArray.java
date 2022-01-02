package lab08.threadPool;

import java.security.SecureRandom;
import java.util.Arrays;

public class SimpleArray {

	// shared integer array
	private final  int[] sharedData;
	//index of next element
	private int currentIndex = 0;
	private final static SecureRandom random = new SecureRandom();
	
	// construct SimpleArray with given size
	public SimpleArray(int size) {
		// initialize an array based on specific size
		sharedData = new int[size];
	}
	
	// method to add value to sharedData
	public synchronized void add(int value) {
		
		//store the currentIndex
		int position = currentIndex;
		
		//Get current thread
		Thread currentThread = Thread.currentThread();

		try {
			//put the thread to sleep
			Thread.sleep(random.nextInt(500));
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		//assign value to the position of array sharedData
		sharedData[position] = value;
		System.out.printf("%s wrote %2d to element %d.\n",
				currentThread.getName(), value, position);
		
		++currentIndex;
		System.out.printf("Next write index is %d\n", currentIndex);
	}
	
	public String toString() {
		
		return Arrays.toString(sharedData);
		
	}

}
