package racingcar.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.exception.ErrorMessage;

public class CarList {

	private static final String INPUT_ERROR_MESSAGE_LENGTH = "각 자동차의 이름은 다섯글자 이하여야 합니다.";
	private static final String INPUT_ERROR_MESSAGE_EMPTY = "자동차 이름을 하나 이상 입력해야 합니다.";
	private static final String INPUT_ERROR_MESSAGE_DUPLICATE = "자동차 이름이 중복되지 않아야 합니다.";
	private static final String INPUT_ERROR_MESSAGE_SPACE = "자동차 이름에 공백이 포함되지 않아야 합니다.";

	private static List<String> carNames = new ArrayList<>();

	public static List<Car> input() {
		getValidCarNamesByUserInput();
		return makeCarList();
	}

	private static void getValidCarNamesByUserInput() {
		while (carNames.isEmpty() || isInvalid(carNames)) {
			String input = Console.readLine();
			carNames = Arrays.asList(input.split(","));
		}
	}

	private static List<Car> makeCarList() {
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private static boolean isInvalid(List<String> carNames) {
		try {
			isEmptyInput(carNames);
			isLengthSixOrMore(carNames);
			isNameDuplicate(carNames);
			ContainSpaceOnName(carNames);
			return false;
		} catch (IllegalArgumentException e) {
			ErrorMessage.print(e.getMessage());
			return true;
		}
	}

	private static void isEmptyInput(List<String> carNames) {
		if (carNames.size() == 1 && carNames.get(0).isEmpty()) {
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_EMPTY);
		}
	}

	private static void isLengthSixOrMore(List<String> carNames) {
		for (String name : carNames) {
			if (name.length() > 5) {
				throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_LENGTH);
			}
		}
	}

	private static void isNameDuplicate(List<String> carNames) {
		if (carNames.size() != carNames.stream().distinct().count()) {
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_DUPLICATE);
		}
	}

	private static void ContainSpaceOnName(List<String> carNames) {
		for (String name : carNames) {
			if (name.contains(" ")) {
				throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_SPACE);
			}
		}
	}

}
