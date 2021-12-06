package racingcar;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void forward(RandomForward randomForward) {
		if (randomForward.isForward()) {
			this.position++;
		}
		return;
	}
}
