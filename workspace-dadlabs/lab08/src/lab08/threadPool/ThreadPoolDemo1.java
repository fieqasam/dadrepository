package lab08.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * This program to demonstrate the implementation of thread pool
 * @author Nurul Afiqah
 */

public class ThreadPoolDemo1 {

	public static void main(String[] args) {
		
		// create SimpleArray object with 6 params
		SimpleArray sharedArray = new SimpleArray(6);
		
		//create two object from ArrayWriter
		ArrayWriter write1 = new ArrayWriter(1, sharedArray);
		ArrayWriter write2 = new ArrayWriter(11, sharedArray);
		
		//execute the tasks with an ExcutorService
		//submit to Executor
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(write1);
		executor.execute(write2);
		
		// Shutdown the executor
		// No new task will be accepted, the existing will continue until finished
		executor.shutdown();
		
		try {
			
			//Wait for 1 minute for both writers to finish executing
			boolean endFlag = executor.awaitTermination(1, TimeUnit.MINUTES);
			
			if(endFlag) {
				//print content of shared array
				
				System.out.println("\nContent of SimpleArray");
				System.out.println(sharedArray);
				
			}else {
				
				System.out.println("Timed out while waiting for tasks to finish");
			}
		} catch(Exception ex) {
			
			ex.printStackTrace();
		}
		
	}

}
