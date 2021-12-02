package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {
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
		if (carList.isEmpty()) {
			return winnerCars;
		}
		Car winnerCar = carList.get(0);
		winnerCars.add(winnerCar);
		for (int i = 1; i < carList.size(); i++) {
			if (winnerCar.getPosition() <= carList.get(i).getPosition()) {
				winnerCars.add(carList.get(i));
			}
		}
		return winnerCars;
	}
}
