package seonggyu.cars;

import java.util.List;
import java.util.ArrayList;

public class Cars {
	private List<Car> cars = new ArrayList<Car>();
	
	public Cars(List<String> carNames) {
		carNames.stream()
			.forEach(carName -> addNewCar(carName));
	}
	
	private void addNewCar(String carName) {
		Car newCar = new Car(carName);
		this.cars.add(newCar);
	}

	public void printNamesAndPositions() {
		this.cars.stream()
			.forEach(car -> car.printNameAndPosition());
	}
	
	public void decidePositions() {
		this.cars.stream()
			.forEach(car -> car.decidePosition());
	}
	
	public Winners getWinners() {
		Winners winners = new Winners();
		this.cars.stream()
			.filter(car -> car.isWinner(winners.getMaxDistance()))
			.forEach(car -> winners.add(car));
		return winners;
	}
}
