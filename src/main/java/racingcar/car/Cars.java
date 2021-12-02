package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private List<Car> carList;
	private CarMovement carMovement;

	public Cars(List<Car> carList) {
		this.carList = carList;
		this.carMovement = new CarMovement();
	}

	public List<String> move() {
		List<String> moveResult = new ArrayList<>();
		for (Car car : carList) {
			if (carMovement.isMoveForward()) {
				car.moveForward();
			}
			moveResult.add(car.positionToString());
		}
		return moveResult;
	}
}
