package racingcar.utils.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.utils.Const;
import racingcar.utils.validator.NameValidator;

public class CarsReader {
	public static List<Car> readCars() {
		System.out.println(Const.CAR_INPUT_MESSAGE);
		List<Car> result;
		String userInput = Console.readLine();
		List<String> names = Arrays.asList(userInput.split(Const.NAME_SEPARATOR));

		try {
			result = generateCars(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readCars();
		}

		return result;
	}

	private static List<Car> generateCars(List<String> names) {
		List<Car> result = new ArrayList<>();

		for (String name : names) {
			result.add(new Car(NameValidator.validate(name)));
		}

		return result;
	}
}
