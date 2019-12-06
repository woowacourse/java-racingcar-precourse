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
	
	public void printNames() {
		cars.stream()
			.forEach(car -> System.out.println(car.getName()));
	}

	public void printNamesAndPositions() {
		cars.stream()
			.forEach(car -> car.printNameAndPosition());
	}
	
	public void decidePositions() {
		cars.stream()
			.forEach(car -> car.decidePosition());
	}
}
