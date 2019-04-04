/*
 * Parser.java
 */

package domain;

import java.util.ArrayList;
import java.util.List;

class Parser {
	private final static String COMMA_PATTERN = ",";
	private final static String BLANK_PATTERN = "\\s*";
	private static final int NAME_MAX = 5;

	public static List<Car> strToListOfCar(String input) throws IllegalArgumentException {
		checkBlank(input);
		return makeListOfCars(input);
	}

	private static List<Car> makeListOfCars(String input) {
		List<Car> carList = new ArrayList<>();
		String[] strArr = splitStrWithComma(input);
		for (String carName : strArr) {
			carList.add(makeCar(carName.trim()));
		}
		return carList;
	}

	private static Car makeCar(String carName) {
		checkBlank(carName);
		checkCarName(carName);
		return new Car(carName);
	}

	private static String[] splitStrWithComma(String inputOfCarNames) {
		return inputOfCarNames.split(COMMA_PATTERN);
	}

	private static void checkBlank(String input) throws IllegalArgumentException {
		if (input.matches(BLANK_PATTERN)) {
			throw new IllegalArgumentException("빈 칸을 입력했습니다");
		}
	}

	private static void checkCarName(String input) throws IllegalArgumentException {
		if (input.length() > NAME_MAX) {
			throw new IllegalArgumentException("자동차 이름을 5자 이상 입력했습니다");
		}
	}

	public static int strToInt(String input) throws IllegalArgumentException {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해주세요");
		}
	}

}
