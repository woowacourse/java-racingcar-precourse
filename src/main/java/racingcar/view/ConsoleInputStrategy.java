package racingcar.view;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ConsoleInputStrategy implements InputStrategy {
	@Override
	public Cars getCars() {
		String carNamesInput = Console.readLine();
		validateCarNames(carNamesInput);
		String[] names = carNamesInput.split(",");
		List<Car> cars = new LinkedList<>();
		Arrays.stream(names).forEach(name -> {
			Car car = new Car(name);
			cars.add(car);
		});
		return new Cars(cars);
	}

	@Override
	public int getTryNumber() {
		String inputTryNumber = Console.readLine();
		validateTryNumber(inputTryNumber);
		return Integer.parseInt(inputTryNumber);
	}
}
