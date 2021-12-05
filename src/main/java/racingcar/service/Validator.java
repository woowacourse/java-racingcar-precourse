package racingcar.service;

import java.util.List;

import racingcar.constants.RaceConstants;
import racingcar.constants.ViewConstants;

public class Validator {

	public void checkCarNames(List<String> carNames) throws IllegalArgumentException {
		for(String carName : carNames) {
			checkCarNameSize(carName);
			checkCarNameContainsBlank(carName);
		}
	}

	public void checkCarsSize(List<String> carNames) throws IllegalArgumentException {
		if(carNames == null || carNames.size() == 0) {
			throw new IllegalArgumentException(ViewConstants.ERROR_CAR_SIZE);
		}
	}

	private void checkCarNameSize(String carName) {
		if(carName.length() > RaceConstants.CAR_NAME_SIZE) {
			throw new IllegalArgumentException(ViewConstants.ERROR_CAR_NAMES);
		}
	}

	private void checkCarNameContainsBlank(String carName) {
		if(carName.equals("") || carName.contains(RaceConstants.BLANK)) {
			throw new IllegalArgumentException();
		}
	}

	public void checkNumberOfRacesDigit(String numberString) throws IllegalArgumentException {
		if(!numberString.chars().allMatch( Character::isDigit )) {
			throw new IllegalArgumentException();
		}
	}

	public void checkNumberOfRacesRange(int numberOfRange) throws IllegalArgumentException {
		if(numberOfRange <= 0) {
			throw new IllegalArgumentException();
		}
	}
}
