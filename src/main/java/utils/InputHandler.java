package utils;

public class InputHandler {
	public static String[] splitByComma(String userInput) {
		String[] userInputs = userInput.split(",");

		if(InputValidator.isDuplicated(userInputs)) {
			throw new IllegalArgumentException("중복된 이름이 존재합니다.");
		}
		if(InputValidator.isEmptyLine(userInputs)) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		if(InputValidator.isOutOfRange(userInputs)) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
		return userInputs;
	}
}
