package racingcar.service;

import java.util.List;

import racingcar.constants.RaceConstants;

public class Validator {

	public void checkCarNames(List<String> carNames) throws IllegalArgumentException{
		for(String carName : carNames) {
			checkCarNameSize(carName);
			checkCarNameNotContainsBlank(carName);
		}
	}

	private void checkCarNameSize(String carName) {
		if(carName.length() > RaceConstants.CAR_NAME_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void checkCarNameNotContainsBlank(String carName) {
		if(carName.contains(RaceConstants.BLANK)) {
			throw new IllegalArgumentException();
		}
	}

	public void checkNumberOfRaces(String numberString) throws IllegalArgumentException{
		if(!numberString.chars().allMatch( Character::isDigit )) {
			throw new IllegalArgumentException();
		}
	}
}
