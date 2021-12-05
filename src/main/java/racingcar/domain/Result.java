package racingcar.domain;

public class Result {
	private final String carName;
	private final int carPosition;

	public Result(Car car) {
		this.carName = car.getName();
		this.carPosition = car.getPosition();
	}

	public String getCarName() {
		return this.carName;
	}

	public int getCarPosition() {
		return this.carPosition;
	}
}
