package racingcar.service;

import java.util.List;

import racingcar.constants.Constants;

public class Validator {
	public void checkCarsNameSize(List<String> carNames) throws IllegalArgumentException{
		for(String carName : carNames) {
			if(carName.length() > Constants.CAR_NAME_SIZE) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkNumber(String numberString) throws IllegalArgumentException{
		if(!numberString.chars().allMatch( Character::isDigit )) {
			throw new IllegalArgumentException();
		}
	}
}
