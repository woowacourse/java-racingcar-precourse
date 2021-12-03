package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Referee implements Comparator<Car> {
	@Override
	public int compare(Car car1, Car car2) {
		return car2.getPosition() - car1.getPosition();
	}

	public List<Car> selectWinners(List<Car> cars) {
		int winnerPosition = cars.get(0).getPosition();
		List<Car> winnerCars = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == winnerPosition) {
				winnerCars.add(car);
			}
		}
		return winnerCars;
	}
}
