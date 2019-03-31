/*
 * Parser.java
 */
package domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	private final static String regex = "\\s*,\\s*";

	public static List<Car> stringToListOfCar(String input) {
		List<Car> carList = new ArrayList<Car>();
		String[] arrayOfCars = splitCarsWithComma(input);   // 문자열 -> 배열
		for (int i = 0; i < arrayOfCars.length; i++) {
			carList.add(new Car(arrayOfCars[i]));
		}
		return carList;
	}

	public static int stringToInt(String input) throws InvalidParameterException {
		if (isNumber(input)) {
			return Integer.parseInt(input);
		}
		throw new InvalidParameterException("숫자를 입력하세요");
	}

	private static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static String[] splitCarsWithComma(String inputOfCarNames) {
		String[] arrayOfCarName;
		inputOfCarNames = eraseBlank(inputOfCarNames);
		arrayOfCarName = inputOfCarNames.split(regex);
		return arrayOfCarName;
	}

	private static String eraseBlank(String input) {
		return input.trim();
	}
}
