package racingcar;

public class Car {

	private static final String namingErrorMessage = "길이는 5글자 이내로 입력해야 합니다.";
	private static final int lengthLimit = 5;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getCarName() {
		return this.name;
	}

	private void validateName(String name) {
		if (name.length() > lengthLimit) {
			throw new IllegalArgumentException(namingErrorMessage);
		}
	}
	// 추가 기능 구현
}
