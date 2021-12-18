package multithreadingLab.exercise1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class demonstarte the task to display current date and thread name
 * 
 * @author Nurul Afiqah
 *
 */

public class StatementPrinter extends Thread{
	
	/**
	 * This methods prints name of thread and current date
	 * 
	 * @param currentThread -  name of current thread
	 * 
	 */
	public void printStatement (String currentThread) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date date = new Date();
		
		String currentDate = formatter.format(date);
		
		for (int counter = 1; counter < 11; counter++) {
			System.out.println(currentThread +"\t"+counter+ "->" + currentDate);
;
		}
	}

	@Override
	public void run() {
		// Get current thread
		Thread currentThread = Thread.currentThread();
		
		//Execute task
		printStatement(currentThread.getName());
		
	}

}
