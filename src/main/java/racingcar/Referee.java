package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Referee implements Comparator<Car> {
	private Cars cars;

	public Referee(Cars cars) {
		this.cars = cars;
	}

	@Override
	public int compare(Car car1, Car car2) {
		return car2.getPosition() - car1.getPosition();
	}

	public List<Car> selectWinners() {
		List<Car> carList = this.cars.getCars();
		int winnerPosition = carList.get(0).getPosition();
		List<Car> winnerCars = new ArrayList<>();
		for (Car car : carList) {
			if (car.getPosition() == winnerPosition) {
				winnerCars.add(car);
			}
		}
		return winnerCars;
	}
}
