package racingcar.car;

import java.util.List;

public class Cars {
	private List<Car> carList;
	private CarMovement carMovement;

	public Cars(List<Car> carList) {
		this.carList = carList;
		this.carMovement = new CarMovement();
	}

	public void move() {
		for (Car car : carList) {
			if (carMovement.isMoveForward()) {
				car.moveForward();
			}
		}
	}
}
