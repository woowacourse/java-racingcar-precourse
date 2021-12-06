package racingcar.car;

import java.util.ArrayList;

public class Cars {
	ArrayList<Car> carList;

	Cars() {
		carList = new ArrayList<Car>();
	}

	void setWinnerNameList() {
		carList.forEach(this::pickWinner);
	}

	ArrayList<String> getWinnerNameList() {
		return winnerNameList;
	}

	ArrayList<String> winnerNameList = new ArrayList<>();

	void pickWinner(Car car) {
		if (car.isBiggerThan(maxPosition)) {
			initMaxPositionAndNameList(car);
			winnerNameList.add(car.getName());
		} else if (car.equals(maxPosition)) {
			winnerNameList.add(car.getName());
		}
	}

	int maxPosition = 0;

	void initMaxPositionAndNameList(Car car) {
		winnerNameList = new ArrayList<>();
		maxPosition = car.getPosition();
	}
}
