package racingcar.service;

import racingcar.domain.Car;

public class NamingProcess {

	public static final String COMMA = ",";

	public static String[] parseString(String inputString) {
		return inputString.split(COMMA);
	}

	public static Car[] StringToArray(String[] nameList) {
		Car[] carList = new Car[nameList.length];
		for (int i = 0; i < nameList.length; i++) {
			Car car = Car.create(nameList[i]);
			carList[i] = car;
		}
		return carList;
	}
}
