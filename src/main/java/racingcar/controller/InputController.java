package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.view.ExceptionView;
import racingcar.view.InputView;

import static racingcar.utils.InputValidation.*;

public class InputController {

	public static final String NAME_DELIMITER = ",";

	public static List<Car> createCars() {
		try {
			InputView.carNameUI();
			return toCars(toNames(Console.readLine()));
		} catch (IllegalArgumentException e) {
			ExceptionView.exceptUI(e.getMessage());
			return createCars();
		}
	}

	public static int createCount() {
		try {
			InputView.countUI();
			return toCount(Console.readLine());
		} catch (IllegalArgumentException e) {
			ExceptionView.exceptUI(e.getMessage());
			return createCount();
		}
	}

	public static String[] toNames(String input) throws IllegalArgumentException {
		validateContainDelimiter(input);
		String[] names = input.split(NAME_DELIMITER);
		validateSize(names);
		return names;
	}

	public static List<Car> toCars(String[] names) throws IllegalArgumentException {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public static int toCount(String input) throws IllegalArgumentException {
		validateIsNumber(input);
		validateIsZero(input);
		return Integer.parseInt(input);
	}
}
