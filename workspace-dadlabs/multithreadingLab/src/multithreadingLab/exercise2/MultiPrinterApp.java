package multithreadingLab.exercise2;

/**
 * This class demonstrate name of thread objects
 * 
 * @author Nurul Afiqah
 *
 */

public class MultiPrinterApp {

	public static void main(String[] args) {
		
		// create objects of runnable
		Runnable numerable = new WordPrinter();
		Thread numberThread = new Thread(numerable);
		numberThread.setName("text");
		
		Runnable statement = new randomData();
		Thread statementThread = new Thread(statement);
		statementThread.setName("word1/word2");
	
		
		// Execute thread
		statementThread.start();
		numberThread.start();

	}

}