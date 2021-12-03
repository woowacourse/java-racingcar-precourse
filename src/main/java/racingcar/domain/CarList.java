package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;

public class CarList {

	private static final List<Car> cars = new ArrayList<Car>();
	private static List<String> carNames = new ArrayList<String>();

	public static List<Car> input() {
		getValidCarNamesByUserInput();
		makeCarList();
		return cars;
	}

	private static void getValidCarNamesByUserInput() {
		while (carNames.isEmpty() || isInvalid(carNames)) {
			String input = Console.readLine();
			carNames = Arrays.asList(input.split(","));
		}

	}

	private static void makeCarList() {
		for (String name : carNames) {
			cars.add(new Car(name));
		}
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
		if(carNames.size()==1 && carNames.get(0).isEmpty()){
			throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해야 합니다.");
		}
	}

	private static void isLengthSixOrMore(List<String> carNames) {
		for (String name : carNames) {
			if (name.length() > 5) {
				throw new IllegalArgumentException("각 자동차의 이름은 다섯글자 이하여야 한다.");
			}
		}
	}

	private static void isNameDuplicate(List<String> carNames) {
		if (carNames.size() != carNames.stream().distinct().count()) {
			throw new IllegalArgumentException("자동차 이름이 중복됩니다. 구별 가능한 이름으로 다시 입력해주세요.");
		}
	}

	private static void ContainSpaceOnName(List<String> carNames) {
		for (String name : carNames) {
			if (name.contains(" ")) {
				throw new IllegalArgumentException("자동차 이름에 공백이 포함되지 않도록 다시 입력해주세요.");
			}
		}
	}

}
