package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Cars {

	private final List<Car> cars;
	private static final String WINNER_NAME_DELIMITER = ", ";

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void showCarsPosition() {
		cars.forEach(Car::getMovedPosition);
		OutputView.printNewLine();
	}

	public int getFirstPosition() {
		List<Integer> carsPosition = cars.stream().map(Car::getCurrentPosition)
			.collect(Collectors.toList());
		return Collections.max(carsPosition);
	}

	public String getWinner(int firstPosition) {
		return cars.stream().map(car -> car.getWinnerName(firstPosition))
			.filter(Objects::nonNull)
			.collect(Collectors.joining(WINNER_NAME_DELIMITER));
	}
}
