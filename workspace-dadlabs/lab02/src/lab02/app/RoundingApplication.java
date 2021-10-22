package lab02.app;

import lab02.rounding.RoundingManager;

/**
 * This application rounding the number to the nearest decimal points.
 * @author Nurul Afiqah
 *
 */
public class RoundingApplication {

	public static void main(String[] args) {
		
		System.out.println("Rounding number to the nearest decimal points");
		
		int divident = 200;
		int divisor = 357;
		RoundingManager roundManager = new RoundingManager();
		double value = roundManager.calculatePercentage(divident, divisor);
		
		System.out.println("Progress from"+divisor+"/"+divident+":"+
							value+"%");
		int decimalPoints = 2;
		
		System.out.println("Round to " + decimalPoints + " decimal points: "
				+ roundManager.roundValue(value, decimalPoints) + "%");
				decimalPoints = 0;
				System.out.println("Round to " + decimalPoints + " decimal points: "
				+ roundManager.roundValue(value, decimalPoints) + "%");
	}
}
