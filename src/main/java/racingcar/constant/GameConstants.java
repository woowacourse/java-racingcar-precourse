package racingcar.constant;

public class GameConstants {

	public enum Car {
		MOVE_CRITERION_INCLUSIVE(4);

		private final int value;

		Car(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum CarStringConversion {
		INFIX(" : "),
		GAUGE("-");

		private final String string;

		CarStringConversion(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}
	}

	public enum Game {
		RANDOM_NUMBER_FROM_INCLUSIVE(0),
		RANDOM_NUMBER_TO_INCLUSIVE(9);

		private final int value;

		Game(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum GameStringConversion {
		GAME_RESULT_HINT("실행 결과\n"),
		GAME_RESULT_POSTFIX("\n"),
		GAME_WINNER_HINT("최종 우승자 : "),
		GAME_WINNER_DELIMITER(", ");

		private final String string;

		GameStringConversion(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}
	}

	public enum UserInput {
		NAME_MINIMUM_LENGTH(1),
		NAME_MAXIMUM_LENGTH(5),
		ITERATION_NUMBER_MINIMUM(1);

		private final int value;

		UserInput(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum UserInputException {
		LENGTH_ERROR_HINT("시도 횟수는 숫자여야 한다."),
		NOT_A_INTEGER_ERROR_HINT("시도 횟수는 숫자여야 한다.");

		private static final String EXCEPTION_PREFIX = "";
		private final String string;

		UserInputException(String string) {
			this.string = string;
		}

		public String getString() {
			return EXCEPTION_PREFIX + string;
		}
	}
}
