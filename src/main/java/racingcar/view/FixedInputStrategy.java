package racingcar.view;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class FixedInputStrategy implements InputStrategy {

	String carNamesInput;
	String tryNumbers;

	public FixedInputStrategy(String carNamesInput, String tryNumbers) {
		this.carNamesInput = carNamesInput;
		this.tryNumbers = tryNumbers;
	}

	@Override
	public Cars getCars() {
		validateCarNames(carNamesInput);
		String[] names = carNamesInput.split(",");
		List<Car> cars = new LinkedList<>();
		Arrays.stream(names)
			.forEach(name -> {
				Car car = new Car(name);
				cars.add(car);
			});
		return new Cars(cars);
	}

	@Override
	public int getTryNumber() {
		validateTryNumber(tryNumbers);
		return Integer.parseInt(tryNumbers);
	}
}
