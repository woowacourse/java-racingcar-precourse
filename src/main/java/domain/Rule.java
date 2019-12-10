package domain;

import java.util.ArrayList;
import java.util.Random;

public class Rule {
	private static final Random random = new Random();
	private static final int RANDOM_NUMBER_BOUND = 10;
	private static final int GO_BOUNDARY_NUMBER = 4;
	private static final int START_POSITION = 0;

	static boolean isGo() {
		int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
		return randomNumber >= GO_BOUNDARY_NUMBER;
	}

	public static void setIsWinners(ArrayList<Car> cars) {
		int maxPosition = getMaxPosition(cars);

		for(Car car : cars) {
			if(car.getPosition() == maxPosition) {
				car.setIsWinner();
			}
		}
	}

	private static int getMaxPosition(ArrayList<Car> cars) {
		int maxPosition = START_POSITION;

		for(Car car : cars) {
			maxPosition = updateMaxPosition(car, maxPosition);
		}
		return maxPosition;
	}

	private static int updateMaxPosition(Car car, int maxPosition) {
		if(maxPosition == START_POSITION || maxPosition < car.getPosition()) {
			maxPosition = car.getPosition();
		}
		return maxPosition;
	}
}
