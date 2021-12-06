package racingcar.car;

import java.util.ArrayList;

public class Cars {
	private ArrayList<Car> carList;

	public ArrayList<Car> getList() {
		return carList;
	}

	public Cars() {
		carList = new ArrayList<Car>();
	}

	public void appendCar(String carName) {
		carList.add(new Car(carName));
	}

	ArrayList<String> winnerNameList = new ArrayList<>();

	ArrayList<String> getWinnerNameList() {
		return winnerNameList;
	}

	void setWinnerNameList() {
		carList.forEach(this::pickWinner);
	}

	void pickWinner(Car car) {
		if (car.isSmallerThan(maxPosition)) {
			return;
		} else if (car.isBiggerThan(maxPosition)) {
			initMaxPositionAndNameList(car);
		}
		winnerNameList.add(car.getName());
	}

	int maxPosition = 0;

	void initMaxPositionAndNameList(Car car) {
		winnerNameList = new ArrayList<>();
		maxPosition = car.getPosition();
	}
}
