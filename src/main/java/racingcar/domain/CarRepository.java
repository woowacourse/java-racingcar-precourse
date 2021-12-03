package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {
	private static final int FIRST_INDEX_OF_WINNER_CAR = 0;
	List<Car> carList = new ArrayList<>();

	public void createCars(String[] names) {
		for (String name : names) {
			carList.add(new Car(name));
		}
	}

	public void attemptCarsMoving() {
		for (Car car : carList) {
			car.attemptMoving();
		}
	}

	public List<Car> getCarList() {
		return carList;
	}

	public List<Car> getWinnerCars() {
		Collections.sort(carList);
		List<Car> winnerCars = new ArrayList<>();
		Car winnerCar = carList.get(FIRST_INDEX_OF_WINNER_CAR);
		for (Car car : carList) {
			if (winnerCar.isSamePosition(car)) {
				winnerCars.add(car);
			}
		}
		return winnerCars;
	}
}
