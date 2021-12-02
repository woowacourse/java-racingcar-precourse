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

}
