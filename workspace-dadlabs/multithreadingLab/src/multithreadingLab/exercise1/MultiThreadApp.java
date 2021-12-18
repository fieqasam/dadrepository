package multithreadingLab.exercise1;

/**
 * This class demonstrate name of thread object
 * @author Nurul Afiqah
 *
 */

public class MultiThreadApp {

	public static void main(String[] args) {
		// create objects of thread
		Thread statementPrinter1 = new StatementPrinter();
		Thread statementPrinter2 = new StatementPrinter();
		
		//create objects of thread with name
		Thread printerThread1 = new Thread(statementPrinter1, "printThread");
		Thread printerThread2 = new Thread(statementPrinter2);
		
		//Execute thread
		printerThread2.start();
		printerThread1.start();

	}

}
