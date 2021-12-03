package racingcar.domain;

import racingcar.util.Validator;

public class RacingCar {

	static Validator validator = new Validator();

	private final String name;
	private int position = 0;

	public RacingCar(String name) {
		validator.validateName(name);
		this.name = name;
	}

	public String getCarName() {
		return this.name;
	}

	public int getLocation() {
		return this.position;
	}

	public void moveCar(int distance) {
		this.position += distance;
	}

}
