package racingcar;

import java.util.HashSet;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {
	String carName;
	HashSet<String> carNameSet;

	String checkCarListInput(String carName) {
		boolean condition1 = false;
		boolean condition2 = false;
		boolean condition3 = false;

		while (!(condition1 && condition2 && condition3)){
			try {
				condition1 = isValidLength();
				condition2 = containsNoBlank();
				condition3 = hasNoDuplication();
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				carName = Console.readLine();
			}
		}

		return carName;
	}

	boolean isValidLength(){
		int len = carName.length();
		if (0< len && len <= 5){
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.NOT_ALLOWED_LENGTH_RANGE);
	}

	boolean containsNoBlank(){
		if (carName.contains(" ")){
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.BLANK_NOT_ALLOWED);
	}

	boolean hasNoDuplication(){
		if (!carNameSet.contains(carName)){
			carNameSet.add(carName);
			return true;
		}
		throw new IllegalArgumentException(ErrorMessageText.DUPLICATION_NOT_ALLOWED);
	}

}

class ErrorMessageText{
	static final String START = "[ERROR]";
	static final String BLANK_NOT_ALLOWED = START + "입력에 공백은 허용되지 않습니다.";
	static final String DUPLICATION_NOT_ALLOWED = START + "입력에 중복은 허용되지 않습니다.";
	static final String NOT_ALLOWED_LENGTH_RANGE = START + "이름의 길이는 5이하만 허용됩니다.";
}
