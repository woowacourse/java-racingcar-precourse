package racingcar.domain;

import static racingcar.constant.GameConstants.*;
import static racingcar.util.CarNameValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCars {
	private final List<Car> racingCars;

	public RacingCars() {
		racingCars = makeCars();
	}

	public List<String> getWinner() {
		int maxPosition = racingCars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);

		return racingCars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	public String getExcutionForEachOrderMessage() {
		StringBuilder result = new StringBuilder();
		racingCars.forEach(car -> result.append(car.getNameAndPostionMessage()));
		return result.toString();
	}

	public void move() {
		racingCars.forEach(Car::movePosition);
	}

	public List<Car> makeCars() {
		List<String> carNames = getCarNames();
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private static List<String> getCarNames() {
		List<String> inputCarNames;
		do {
			OutputView.printAskingCarNames();
			inputCarNames = toList(InputView.getInput());
		} while (!isValidCarName(inputCarNames));
		return inputCarNames;
	}

	private static List<String> toList(String carNames) {
		return Arrays.asList(carNames.split(DELIMITER));
	}
}
