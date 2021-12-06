package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MIN_RANDOM_VALUE = 0;
	private static final int MAX_RANDOM_VALUE = 9;
	private static final int FORWARD_STANDARD = 4;
	private static final String CAR_POSITION_MARKER = "-";
	private static final String CAR_PRINT_SEPARATOR = " : ";

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveOrStop() {
		int dice = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
		if (dice >= FORWARD_STANDARD)
			this.position++;
	}

	public void printPosition() {
		StringBuilder outputText = new StringBuilder(name + CAR_PRINT_SEPARATOR);
		for (int i = 0; i < position; i++) {
			outputText.append(CAR_POSITION_MARKER);
		}
		System.out.println(outputText);
	}
}
