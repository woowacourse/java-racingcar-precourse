package racingcar;

import java.util.HashSet;

public class InputValidator {
	private String carName;
	HashSet<String> carNameSet = new HashSet<>();

	static boolean isStrContainOnlyAlphabetOrComma(String str){
		if (str.matches("[a-zA-z,]+")){
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.ENGLISH_AND_COMMA_ONLY);
	}

	public boolean hasValidLengthAndNoDuplication(String carName) {
		this.carName = carName;
		return isValidLength() && hasNoDuplication();
	}

	private boolean isValidLength(){
		int len = carName.length();
		if (len < 0 && len <= 5){
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.NOT_ALLOWED_LENGTH_RANGE);
	}

	private boolean hasNoDuplication(){
		if (carNameSet.contains(carName)) {
			throw new IllegalArgumentException(ErrorMessageText.DUPLICATION_NOT_ALLOWED);
		}
		carNameSet.add(carName);
		return true;
	}
}

class ErrorMessageText{
	static final String START = "[ERROR]";
	static final String ENGLISH_AND_COMMA_ONLY = START + "입력값은 영문과 쉼표만 허용됩니다.";
	static final String DUPLICATION_NOT_ALLOWED = START + "입력에 중복은 허용되지 않습니다.";
	static final String NOT_ALLOWED_LENGTH_RANGE = START + "이름의 길이는 5이하만 허용됩니다.";
}
