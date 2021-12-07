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
			String[] names = input.split(NAME_DELIMITER);
			return toCars(names);
		} catch (IllegalArgumentException e) {
			return createCars();
		}
	}

	public static int createCount() {
		try {
			InputView.countUI();
			String input = Console.readLine();
			validateIsNumber(input);
			validateIsZero(input);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			return createCount();
		}
	}

	public static List<Car> toCars(String[] names) throws IllegalArgumentException {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private static void validateIsZero(String input) throws IllegalArgumentException {
		if (Integer.parseInt(input) == 0) {
			throw new IllegalArgumentException();
		}
	}

	private static void validateIsNumber(String input) throws IllegalArgumentException {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static void validateContainDelimiter(String input) throws IllegalArgumentException {
		if (!input.contains(NAME_DELIMITER)) {
			throw new IllegalArgumentException();
		}
	}
}
