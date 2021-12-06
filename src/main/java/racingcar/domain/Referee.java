package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {
	private List<Car> winnerCars;

	public Car selectWinner(Cars cars){
		List<Car> carList = cars.getCars();
		Car winnerCar = carList.get(0);
		int winnerCarPosition = winnerCar.getPosition();
		for (int i = 1; i < carList.size(); i++) {
			if (winnerCarPosition < carList.get(i).getPosition()) {
				winnerCar = carList.get(i);
			}
		}
		return winnerCar;
	}

	public List<Car> selectWinners(Cars cars) {
		Car winnerCar = selectWinner(cars);
		winnerCars = new ArrayList<>();
		winnerCars.add(winnerCar);
		for (Car car : cars.getCars()) {
			if (winnerCar != car && winnerCar.getPosition() == car.getPosition()) {
				winnerCars.add(car);
			}
		}
		return winnerCars;
	}
}
