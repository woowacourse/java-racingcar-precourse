package racingcar.domain;

import racingcar.type.RangeType;

public class Car {
	
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void goForward() {
		position++;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void move(int generateNumber) {
		if (isPossibleToGoForward(generateNumber)) {
			goForward();
		}
	}

	private boolean isPossibleToGoForward(int generateNumber) {
		return generateNumber >= RangeType.MOVABLE_NUMBER.getValue();
	}
}
