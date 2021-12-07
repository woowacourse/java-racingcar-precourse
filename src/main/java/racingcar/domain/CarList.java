package racingcar.domain;

import java.util.ArrayList;

public class CarList {
	private final ArrayList<Car> cars = new ArrayList<>();
	private int maxPosition = 0;

	public CarList(String[] carNames) {
		for (String carName : carNames) {
			this.cars.add(new Car(carName));
		}
	}

	public void moveAll() {
		for (Car car : this.cars) {
			car.moveForward();
			updateMaxPosition(car);
		}
	}

	public ArrayList<String> getMovementState() {
		ArrayList<String> moveState = new ArrayList<>();
		for (Car car : this.cars) {
			moveState.add(car.toString());
		}
		return moveState;
	}

	public ArrayList<String> getWinners() {
		ArrayList<String> winners = new ArrayList<>();
		for (Car car : this.cars) {
			if (car.positionComparator(this.maxPosition) == 0) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private void updateMaxPosition(Car car) {
		if (car.positionComparator(this.maxPosition) > 0) {
			this.maxPosition++;
		}
	}
}
