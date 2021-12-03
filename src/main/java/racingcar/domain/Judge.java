package racingcar.domain;

import java.util.ArrayList;

public class Judge {
	public static ArrayList<Car> getRacingWinner(Car[] carName) {
		ArrayList<Car> winnerList = new ArrayList<>();
		int maxValue = 0;
		for (Car car : carName) {
			if (car.getPosition() == maxValue) {
				winnerList.add(car);
				continue;
			}
			if (car.getPosition() > maxValue) {
				winnerList.clear();
				winnerList.add(car);
				maxValue = car.getPosition();
			}
		}
		return winnerList;
	}
}
