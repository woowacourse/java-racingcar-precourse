package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private static final int ZERO = 0;

	private List<Car> carList;
	private CarMovement carMovement;

	public Cars(List<Car> carList) {
		this.carList = carList;
		this.carMovement = new CarMovement();
	}

	public List<String> race() {
		List<String> racingResult = new ArrayList<>();
		for (Car each : carList) {
			move(each);
			addResult(racingResult, each);
		}
		return racingResult;
	}

	private void move(Car car) {
		if (carMovement.isMovableForward()) {
			car.moveForward();
		}
	}

	private void addResult(List<String> racingResult, Car car) {
		racingResult.add(car.positionToString());
	}

	public List<String> findFrontCars() {
		List<String> frontCarsName = new ArrayList<>();
		int maxDistance = getMaxDistance();
		for (Car each : carList) {
			insertCarName(frontCarsName, each, maxDistance);
		}
		return frontCarsName;
	}

	private int getMaxDistance() {
		int maxDistance = ZERO;
		for (Car each : carList) {
			maxDistance = Math.max(maxDistance, each.getPosition());
		}
		return maxDistance;
	}

	private void insertCarName(List<String> frontCarsName, Car car, int maxDistance) {
		if (car.getPosition() == maxDistance) {
			frontCarsName.add(car.getName());
		}
	}
}
