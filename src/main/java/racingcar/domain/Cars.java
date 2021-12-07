package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private final List<Car> carList = new ArrayList<>();

	public Cars(String[] array_carNames) {
		ValidatorName.duplicate(array_carNames);
		for (String name : array_carNames) {
			ValidatorName.isNull(name);
			ValidatorName.outOfLength(name);
			this.carList.add(new Car(name));
		}
	}

	public void raceCars() {
		carList.forEach(car -> {
			car.move();
			car.printState();
		});
		System.out.println();
	}
	
	public List<Car> findWinners() {
		Car winnerCar = carList.stream()
				.max(Car::compareTo)
				.orElseThrow(IllegalStateException::new);
		
		return carList.stream()
				.filter(car -> car.getPosition()== winnerCar.getPosition())
				.collect(Collectors.toList());
	}

}
