package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	// 기본 생성자 추가 금지
	// 접근제어자 수정 금지
	// setPosition(int position) 가능하면 사용 금지

	private void moveForward() {
		position++;
	}

	public void printPosition() {

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			stringBuilder.append("-");
		}
		System.out.println(name + " = " + stringBuilder.toString());
	}

	public void moveOrStop() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			moveForward();
		}
	}
}
