package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
	private final List<Car> cars = new ArrayList<>();

	public Cars(Car... cars) {
		Collections.addAll(this.cars, cars);
	}

	public Cars(String names) {
		addCarsToList(names);
	}

	public void controlByRandomNumber() {
		for (Car car : cars) {
			car.controlByNumber(Randoms.pickNumberInRange(0, 9));
		}
	}

	private String[] divideNamesByComma(String names) {
		return names.split(",");
	}

	private void addCarsToList(String names) {
		for (String carName : divideNamesByComma(names)) {
			cars.add(new Car(carName));
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
