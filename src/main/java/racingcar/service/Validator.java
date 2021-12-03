package racingcar.service;

import java.util.List;

import racingcar.constants.Constants;

public class Validator {
	public boolean checkCarsNameSize(List<String> carNames) {
		for(String carName : carNames) {
			if(carName.length() > Constants.CAR_NAME_SIZE) {
				return false;
			}
		}
		return true;
	}

	public boolean checkNumber(String numberString) {
		return numberString.chars().allMatch( Character::isDigit );
	}
}
