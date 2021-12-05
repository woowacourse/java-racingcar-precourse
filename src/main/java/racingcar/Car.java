package racingcar;

public class Car {
	public static final int CAR_NAME_MIN_LENGTH = 1;
	public static final int CAR_NAME_MAX_LENGTH = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		validName(name);
		this.name = name;
	}

	private void validName(String name) {
		if (name.length() < CAR_NAME_MIN_LENGTH || name.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 한다.");
		}
	}
}
