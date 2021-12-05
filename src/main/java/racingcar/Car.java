package racingcar;

public class Car {
	private static final int RANDOM_NUMBER_MINIMUM = 0;
	private static final int RANDOM_NUMBER_MAXIMUM = 9;
	private static final int MINIMUM_CONDITION_MOVE_FORWARD = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	private int makeRandomOneDigitNum() {
		return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
	}

	private int convertRandomNumToForwardStep(int randomNum) {
		if (randomNum > MINIMUM_CONDITION_MOVE_FORWARD) {
			return 1;
		}
		return 0;
	}

	protected void moveCar() {
		position += convertRandomNumToForwardStep(makeRandomOneDigitNum());
	}

	protected String getCurrentPosition() {
		StringBuilder currentPosition = new StringBuilder();
		for (int i = 0; i < position; ++i) {
			currentPosition.append("-");
		}
		return currentPosition.toString();
	}

	protected String getName() {
		return name;
	}
}
