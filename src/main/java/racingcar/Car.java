package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}
	// 추가 기능 구현

	public void goForward() {
		if (GameTools.judgeMoreThan4(GameTools.getRandomNumber())) {
			this.position += 1;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}
}
