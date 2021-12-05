package racingcar;

public class Car {
	private static final int MAX_LENGTH = 5;

	private final String name;
    private int position = 0;

    public Car(String name) {
		if (isNameOverMaxLength(name)) {
			throw new IllegalArgumentException();
		}
        this.name = name;
    }

	private boolean isNameOverMaxLength(String name) {
		return name.length() > MAX_LENGTH;
	}

	// 추가 기능 구현
}
