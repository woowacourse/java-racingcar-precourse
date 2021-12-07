package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> carList = new ArrayList<>();

	public Cars(String[] array_carNames) {
		for (String name : array_carNames) {
			ValidatorName.isNull(name);
			ValidatorName.outOfLength(name);
			this.carList.add(new Car(name));
		}
	}

}
