package domain;

public class Car {
	private final String name;
	private int position = 0;
	/**
	 * 우승한 자동차인지 표시하는 변수 true면 우승한 자동차이다.
	 */
	private boolean isPrize = false;

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

	public void setPrize() {
		isPrize = true;
	}

	public boolean getPrize() {
		return isPrize;
	}

	public void movePosition(int randomNumber) {
		if (randomNumber >= Constant.CAR_MOVE_STANDARD) {
			position = position + 1;
		}
	}
}
