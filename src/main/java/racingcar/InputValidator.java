package racingcar;

import java.util.HashSet;

public class InputValidator {
	String carName;
	HashSet<String> carNameSet = new HashSet<>();

	boolean checkCarListInput(String carName) {
		this.carName = carName;
		return isValidLength() && containsNoBlank() && hasNoDuplication();
	}

	boolean isValidLength(){
		int len = carName.length();
		if (len == 0 || len > 5 ){
			throw new IllegalArgumentException(ErrorMessageText.NOT_ALLOWED_LENGTH_RANGE);
		}
		return true;
	}

	boolean containsNoBlank(){
		if (carName.contains(" ")){
			throw new IllegalArgumentException(ErrorMessageText.BLANK_NOT_ALLOWED);
		}
		return true;
	}

	boolean hasNoDuplication(){
		if (carNameSet.contains(carName)) {
			throw new IllegalArgumentException(ErrorMessageText.DUPLICATION_NOT_ALLOWED);
		}
		carNameSet.add(carName);
		return true;
	}
}

class ErrorMessageText{
	static final String START = "[ERROR]";
	static final String BLANK_NOT_ALLOWED = START + "입력에 공백은 허용되지 않습니다.";
	static final String DUPLICATION_NOT_ALLOWED = START + "입력에 중복은 허용되지 않습니다.";
	static final String NOT_ALLOWED_LENGTH_RANGE = START + "이름의 길이는 5이하만 허용됩니다.";
}
