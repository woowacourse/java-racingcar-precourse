package racingcar;

import static java.lang.String.*;

import org.assertj.core.util.Strings;

public class Car {
	private static final int NAME_LENGTH_MAX = 5;
	private static final String NAME_LENGTH_ERROR = format("[ERROR] 자동차의 이름은 %d자를 초과할 수 없습니다.", NAME_LENGTH_MAX);
	private static final String NAME_EMPTY_ERROR = "[ERROR] 자동차의 이름은 공백일 수 없습니다.";

	private final String name;
	private int position = 0;

	public Car(String name) {
		checkNotEmpty(name);
		checkLength(name);
		this.name = name;
	}

	private void checkNotEmpty(String name) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException(NAME_EMPTY_ERROR);
		}
	}

	private void checkLength(String name) {
		if (name.length() > NAME_LENGTH_MAX) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR);
		}
	}

	// 추가 기능 구현
	public void move(int randomNum) {
		if (canMove(randomNum)) {
			position++;
		}
	}

	private boolean canMove(int randomNum) {
		return randomNum >= 4;
	}

	protected boolean isMoved() {
		return position != 0;
	}
}
