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

	public List<Car> makeCars() {
		List<String> carNames = getCarNames();
		return carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public static List<String> getCarNames() {
		List<String> inputCarNames;
		do {
			OutputView.printAskingCarNames();
			inputCarNames = toList(InputView.getInput());
		} while (!isValidCarName(inputCarNames));
		return inputCarNames;
	}

	private static List<String> toList(String carNames) {
		return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
	}
}
