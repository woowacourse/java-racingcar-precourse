package racingcar.input;

import static racingcar.input.constants.InputConstants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;

public class CarList {
	private static List<String> carNames = new ArrayList<>();

	public static List<Car> input() {
		getValidCarNamesByUserInput();
		return makeCarList();
	}

	private static void getValidCarNamesByUserInput() {
		while (carNames.isEmpty() || isInvalid()) {
			String input = Console.readLine();
			carNames = Arrays.asList(input.split(INPUT_SPLITTER));
		}
	}

	private static List<Car> makeCarList() {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private static boolean isInvalid() {
		try {
			isEmptyInput();
			isLengthSixOrMore();
			isNameDuplicate();
			containBlankInName();
			return false;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return true;
		}
	}

	private static void isEmptyInput() {
		if (carNames.size() == 1 && carNames.get(0).isEmpty()) {
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_EMPTY);
		}
	}

	private static void isLengthSixOrMore() {
		for (String name : carNames) {
			if (name.length() > NAME_LENGTH_LIMIT) {
				throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_LENGTH);
			}
		}
	}

	private static void isNameDuplicate() {
		if (carNames.size() != carNames.stream().distinct().count()) {
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_DUPLICATE);
		}
	}

	private static void containBlankInName() {
		for (String name : carNames) {
			if (name.contains(BLANK)) {
				throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_SPACE);
			}
		}
	}

}
