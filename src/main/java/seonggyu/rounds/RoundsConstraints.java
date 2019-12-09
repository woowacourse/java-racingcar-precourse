package seonggyu.rounds;

public class RoundsConstraints {
	private static final int MIN_ROUNDS = 1;

	/* 새로운 제한 조건이 생기면 메서드를 만들어 여기에 추가한다 */
	public static void checkValidRounds(int inputRounds) {
		checkVaidRangeOfRounds(inputRounds);
	}

	private static void checkVaidRangeOfRounds(int inputRounds) {
		if (inputRounds < MIN_ROUNDS) {
			throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
		}
	}
}
