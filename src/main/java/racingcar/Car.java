package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void move() {
		position++;
	}

	public void printPosition() {
		StringBuilder message = new StringBuilder();
		message.append(name);
		message.append(" : ");
		for (int i = 0; i < position; i++) {
			message.append("-");
		}
		System.out.println(message);
	}
}
