package racingcar.service;

import java.util.List;

import racingcar.constants.RaceConstants;
import racingcar.constants.ViewConstants;

public class Validator {

	public void checkCarNames(List<String> carNames) throws IllegalArgumentException {
		for(String carName : carNames) {
			checkCarNameSize(carName);
			checkCarNameEmpty(carName);
		}
	}

	public void checkNumberOfCars(List<String> carNames) throws IllegalArgumentException {
		if(carNames == null || carNames.size() == 0) {
			throw new IllegalArgumentException(ViewConstants.ERROR_NUMBER_OF_CARS);
		}
	}

	private void checkCarNameSize(String carName) {
		if(carName.length() > RaceConstants.CAR_NAME_SIZE) {
			throw new IllegalArgumentException(ViewConstants.ERROR_CAR_NAMES);
		}
	}

	private void checkCarNameEmpty(String carName) {
		if(carName.equals(RaceConstants.EMPTY)) {
			throw new IllegalArgumentException();
		}
	}

	public void checkNumberOfRacesDigit(String numberString) throws IllegalArgumentException {
		if(numberString.length() == 0 || !numberString.chars().allMatch( Character::isDigit )) {
			throw new IllegalArgumentException();
		}
	}

	public void checkNumberOfRacesRange(String numberOfRange) throws IllegalArgumentException {
		if(numberOfRange.equals(String.valueOf(RaceConstants.NOT_ALLOWED_NUMBER))) {
			throw new IllegalArgumentException();
		}
	}
}
