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

	private List<Car> getWinners() {
		return this.cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}

	private void updateMaxPosition(int nowPosition) {
		if(nowPosition > maxPosition) {
			maxPosition = nowPosition;
		}
	}
}
