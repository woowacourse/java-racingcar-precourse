package racingcar.service;

import static racingcar.message.GuideMessage.*;

import java.util.Arrays;

import racingcar.domain.Car;

public class NamingProcess {

	public static Car[] StringToArray(String inputString) {
		String[] nameList = parseString(inputString);
		Car[] carList = new Car[nameList.length];
		for (int i = 0; i < nameList.length; i++) {
			Car car = Car.create(nameList[i]);
			carList[i] = car;
		}
		return carList;
	}

	public static String[] parseString(String inputString) {
		String[] nameList = inputString.split(",");
		validateDuplication(nameList);
		return nameList;
	}

	private static void validateDuplication(String[] nameList) {
		if (Arrays.stream(nameList)
			.distinct()
			.count() != nameList.length) {
			throw new IllegalArgumentException(ERR_NAME_DUPLICATION);
		}
	}
}
