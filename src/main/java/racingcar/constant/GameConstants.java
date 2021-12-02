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
		LENGTH_ERROR_HINT("이름은 최소 1글자 최대 5글자이다."),
		NOT_A_INTEGER_ERROR_HINT("시도 횟수는 숫자여야 한다.");

		private static final String EXCEPTION_PREFIX = "[ERROR] ";
		private final String string;

		UserInputException(String string) {
			this.string = string;
		}

		public String getString() {
			return EXCEPTION_PREFIX + string;
		}
	}

	public enum UserInputHint {
		NAME_INPUT_HINT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
		ITERATION_NUMBER_INPUT_HINT("시도할 회수는 몇회인가요?");
		private final String string;

		UserInputHint(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}
	}

	public enum UserInputDelimiter {
		USER_NAME_INPUT_DELIMITER(",");

		private final String string;

		UserInputDelimiter(String string) {
			this.string = string;
		}

		public String getString() {
			return string;
		}
	}
}
