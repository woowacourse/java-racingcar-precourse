package racingcar;

public class Validator {
	public static void validateNameLength(String name) {
		if (name.length() > Constant.NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(Constant.NAME_MAX_LENGTH_EXCEED_ERROR_MESSAGE);
		}
	}

	public static void validateBlankName(String name){
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constant.NAME_MINIMUN_LENGTH_UNDER_ERROR_MESSAGE);
		}
	}

	public static void validateGameRound(int gameRound) {
		if (gameRound < Constant.MINIMUM_GAME_ROUND) {
			throw new IllegalArgumentException();
		}
	}
}
