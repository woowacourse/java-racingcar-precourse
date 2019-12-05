package domain;

import java.util.List;

public class InputException {
	private static final int MAX_LEN_OF_NAME = 5;
	private static final int MIN_LEN_OF_NAME = 1;
	private static final int MIN_ROUNDS = 1;
	
	public static void checkOverlapping(List<String> carNames, String carName) {
		if (carNames.contains(carName)) {
			throw new IllegalArgumentException("중복되지 않은 이름들을 입력해주세요");
		}
	}
	
	public static void checkValidCarNames(List<String> carNames) {
		for (int i = 0; i < carNames.size(); i++) {
			checkValidLenOfCarName(carNames.get(i));
		}
	}
	
	private static void checkValidLenOfCarName(String carName) {
		if ((carName.length() > MAX_LEN_OF_NAME)
				|| (carName.length() < MIN_LEN_OF_NAME)) {
			throw new IllegalArgumentException("5자 이하의 비어있지 않은 이름만 입력해주세요");
		}
	}
	
	public static void checkValidRounds(int rounds) {
		if(rounds < MIN_ROUNDS) {
			throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
		}
	}
}
