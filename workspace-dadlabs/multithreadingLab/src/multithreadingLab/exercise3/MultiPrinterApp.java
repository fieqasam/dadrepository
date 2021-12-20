package multithreadingLab.exercise3;

import multithreadingLab.exercise2.WordPrinter;
import multithreadingLab.exercise2.randomData;

public class MultiPrinterApp {

	public static void main(String[] args) {
		
		// create objects of runnable
		Runnable statement = new ArrayData();
		Thread statementThread = new Thread(statement);
		statementThread.setName("word1");
	
		
		// Execute thread
		statementThread.start();


	}

}
