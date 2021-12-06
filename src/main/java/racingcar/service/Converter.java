package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.constants.RaceConstants;
import racingcar.domain.Car;

public class Converter {
	public List<String> convertStringToList(String inputString) {
		String [] splitedArray = inputString.split(RaceConstants.CUT_OFF_POINT);
		return replaceBlank(splitedArray);
	}

	private List<String> replaceBlank(String [] carNames) {
		List<String> replacedList = new ArrayList<>();
		for(String carName : carNames) {
			replacedList.add(carName.replace(" ", ""));
		}
		return replacedList;
	}

	public List<Car> convertStringListToCarList(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for(String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
		return cars;
	}

	public int convertStringToInt(String numberString) {
		return Integer.parseInt(numberString);
	}
}
