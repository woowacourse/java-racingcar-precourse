package domain;

import java.util.ArrayList;
import java.util.Random;

public class Rule {
	private static final Random random = new Random();
	private static final int RANDOM_NUMBER_BOUND = 10;
	private static final int GO_BOUNDARY_NUMBER = 4;

	public static boolean isGo() {
		int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
		return randomNumber >= GO_BOUNDARY_NUMBER;
	}

	public static ArrayList<String> getWinners(ArrayList<Car> cars) {
		ArrayList<String> result = new ArrayList<>();
		int maxPosition = getMaxPosition(cars);

		for(Car car : cars) {
			if(car.getPosition() == maxPosition) {
				result.add(car.getName());
			}
		}
		return result;
	}

	private static int getMaxPosition(ArrayList<Car> cars) {
		int maxPosition = 0;

		for(Car car : cars) {
			if(maxPosition == 0 || maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}
}
