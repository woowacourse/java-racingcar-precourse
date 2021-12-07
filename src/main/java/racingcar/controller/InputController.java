package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.view.InputView;

public class InputController {

	private static final String NAME_DELIMITER = ",";

	public static List<Car> createCars() {
		try {
			InputView.carNameUI();
			String input = Console.readLine();
			validateContainDelimiter(input);
			String[] names = Console.readLine().split(NAME_DELIMITER);
			return toCars(names);
		} catch (IllegalArgumentException e) {
			return createCars();
		}
	}

	public static List<Car> toCars(String[] names) throws IllegalArgumentException {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public static void validateContainDelimiter(String input) throws IllegalArgumentException {
		if (!input.contains(NAME_DELIMITER)) {
			throw new IllegalArgumentException();
		}
	}
}
