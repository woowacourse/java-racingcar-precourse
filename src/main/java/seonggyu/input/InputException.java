package seonggyu.input;

import java.util.List;

public class InputException {
	private static final int MAX_LEN_OF_NAME = 5;
	private static final int MIN_LEN_OF_NAME = 1;
	private static final int MIN_NUM_OF_NAMES = 2;
	private static final int MIN_ROUNDS = 1;
	
	/* 이름에 추가적인 제한 사항이 생기면 제한 사항에 따른 메서드를 따로 만들어서 여기에 추가한다 */
	public static void checkValidCarNames(List<String> carNames) {
		checkValidLenOfCarNames(carNames);
		checkValidNumOfCarNames(carNames);
	}
	
	private static void checkValidLenOfCarNames(List<String> carNames) {
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
	
	private static void checkValidNumOfCarNames(List<String> carNames) {
		if (carNames.size() < MIN_NUM_OF_NAMES) {
			throw new IllegalArgumentException("2개 이상의 이름을 입력해주세요");
		}
			
	}
	
	/* 회수에 추가적인 제한 사항이 생기면 제한 사항에 따른 메서드를 따로 만들어서 여기에 추가한다 */
	public static void checkValidRounds(int rounds) {
		checkVaidRangeOfRounds(rounds);
	}
	
	private static void checkVaidRangeOfRounds(int rounds) {
		if(rounds < MIN_ROUNDS) {
			throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
		}
	}
}
