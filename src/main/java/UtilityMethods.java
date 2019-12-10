import java.util.ArrayList;

import domain.Car;

public class UtilityMethods {
	public static Car[] sliceString(String target) {
		String[] slicedString = target.split(",");
		Car[] cars = new Car[slicedString.length];

		for (int i = 0; i < slicedString.length; i++) {
			cars[i] = new Car(slicedString[i]);
		}

		return cars;
	}

	public static String getListToString(ArrayList<String> winners) {
		int winnerCount = 0;
		String winnerString = "";

		for (String winner : winners) {
			if (winnerCount == 0) {
				winnerString = winner;
			} else if (winnerCount > 0) {
				winnerString = winnerString + ", " + winner;
			}
			winnerCount++;
		}

		return winnerString;
	}
}
