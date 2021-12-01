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
}
