package seonggyu.participants;

public class CarConstraints {
	private static final int MAX_LEN_OF_NAME = 5;
	private static final int MIN_LEN_OF_NAME = 1;
	
	/* 새로운 제한 조건이 생기면 메서드를 만들어 여기에 추가한다 */
	public static void checkValidCarName(String inputName) {
		checkValidLenOfCarName(inputName);
	}
	
	private static void checkValidLenOfCarName(String inputName) {
		if ((inputName.length() > MAX_LEN_OF_NAME)
				|| (inputName.length() < MIN_LEN_OF_NAME)) {
			throw new IllegalArgumentException("5자 이하의 비어있지 않은 이름만 입력해주세요");
		}
	}
	
}
