package racingcar.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.InputValidation;

public class InputView {

	private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	public static Cars inputCarsName(String splitRegex) {

		System.out.println(INPUT_CARS_NAME);
		String input = Console.readLine();

		try {
			InputValidation.checkCarNameValidation(input, splitRegex);
			return new Cars(Arrays
				.stream(input.split(splitRegex))
				.map(Car::new)
				.collect(Collectors.toList())
			);
		} catch (IllegalArgumentException e) {
			return inputCarsName(splitRegex);
		}
	}
}
