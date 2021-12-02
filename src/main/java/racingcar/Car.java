package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		validateNameLength(name);
		this.name = name;
	}

	// 추가 기능 구현
	public void validateNameLength(String name) {
		if (name.length() > Constant.NAME_MAX_LENGTH) {
			throw new IllegalArgumentException(Constant.NAME_MAX_LENGTH_EXCEED_ERROR_MESSAGE);
		}
	}

	public void proceed(int randomValue) {
		if (randomValue >= Constant.PROCEED_CRITERIA) {
			position++;
		}
	}
}
