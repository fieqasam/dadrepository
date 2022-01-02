package lab08.threadPool;

/*
 * This class is add integers to an array shared with other Runnables
 * 
 */
public class ArrayWriter implements Runnable {
	
	private final SimpleArray sharedSimpleArray;
	private int startValue;

	//This constructor takes two arguments integer value and reference to SimpleArray object
	// add int value to the simpleArray object
	public ArrayWriter(int value, SimpleArray simpleArray) {
		
		startValue = value;
		sharedSimpleArray = simpleArray;
		
	}
	
	@Override
	public void run() {
		
		for(int i= startValue; i < startValue + 3; i++) {
			
			//add an element to the sharedArray 
			sharedSimpleArray.add(i);
		}
		
	}

}
