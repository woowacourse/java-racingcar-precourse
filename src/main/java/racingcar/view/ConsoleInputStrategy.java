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
		while (true) {
			String carNamesInput = Console.readLine();
			List<Car> cars = new LinkedList<>();
			String[] names = carNamesInput.split(",");
			try {
				Arrays.stream(names).forEach(name -> cars.add(new Car(name)));
				return new Cars(cars);
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	@Override
	public int getTryNumber() {
		String inputTryNumber = Console.readLine();
		validateTryNumber(inputTryNumber);
		return Integer.parseInt(inputTryNumber);
	}
}
