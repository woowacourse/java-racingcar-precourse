package racingcar.utils.reader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.utils.SystemMessage;
import racingcar.utils.validator.NameValidator;

public class CarsReader {
	private static final String NAME_SEPARATOR = ",";

	public static List<Car> readCars() {
		System.out.println(SystemMessage.CAR_INPUT_MESSAGE);
		List<Car> result;
		String userInput = Console.readLine();
		List<String> names = Arrays.asList(userInput.split(NAME_SEPARATOR));

		try {
			result = generateCars(names);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readCars();
		}

		return result;
	}

	private static List<Car> generateCars(List<String> names) {
		return names.stream()
			.map(name -> new Car(NameValidator.validate(name)))
			.collect(Collectors.toList());
	}
}
