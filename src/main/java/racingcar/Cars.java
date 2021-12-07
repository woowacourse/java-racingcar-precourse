package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for (String name: names) {
			cars.add(new Car(name));
		}
		this.cars = cars;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void forward(RandomForward randomForward) {
		this.cars.stream().forEach(car -> {
			car.forward(randomForward);
		});
	}
}
