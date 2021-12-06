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
		while (carNames.isEmpty() || isInvalid()) {
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

	private static boolean isInvalid() {
		try {
			isEmptyInput();
			isLengthSixOrMore();
			isNameDuplicate();
			ContainSpaceOnName();
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
			if (name.length() > 5) {
				throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_LENGTH);
			}
		}
	}

	private static void isNameDuplicate() {
		if (carNames.size() != carNames.stream().distinct().count()) {
			throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_DUPLICATE);
		}
	}

	private static void ContainSpaceOnName() {
		for (String name : carNames) {
			if (name.contains(" ")) {
				throw new IllegalArgumentException(INPUT_ERROR_MESSAGE_SPACE);
			}
		}
	}

}
