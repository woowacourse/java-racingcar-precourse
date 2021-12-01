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
}
