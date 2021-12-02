package racingcar.game;

import java.util.List;

import racingcar.car.Cars;

public class Winners {
	private static final String WINNER_FORMAT = "최종 우승자 : ";
	private static final String DELIMITER = ", ";
	private Cars cars;

	Winners(Cars cars) {
		this.cars = cars;
	}

	public String getWinners() {
		List<String> winnerCarsName = cars.findFrontCars();
		return WINNER_FORMAT + String.join(DELIMITER, winnerCarsName);
	}
}
