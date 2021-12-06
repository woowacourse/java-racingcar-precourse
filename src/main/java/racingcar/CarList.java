package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
	private final ArrayList<Car> cars = new ArrayList<>();
	private int maxPosition = 0;

	public CarList(String [] carNames){
		for (String carName : carNames) {
			this.cars.add(new Car(carName));
		}
	}

	public void moveAll() {
		for (Car car : this.cars) {
			car.moveForward();
			updateMaxPosition(car.getPosition());
		}
	}

	public ArrayList<String> getMoveState() {
		ArrayList<String> moveState = new ArrayList<>();
		for (Car car : this.cars) {
			moveState.add(car.toString());
		}
		return moveState;
	}

	public ArrayList<String> getWinners() {
		ArrayList<String> winners = new ArrayList<>();
		for (Car car : this.cars) {
			if (car.getPosition() == this.maxPosition){
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private void updateMaxPosition(int nowPosition) {
		if(nowPosition > this.maxPosition) {
			this.maxPosition = nowPosition;
		}
	}
}
