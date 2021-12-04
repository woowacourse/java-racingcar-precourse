package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.messages.InputMessages;
import racingcar.utils.validator.CarNameValidator;

public class CarNameInput {
	CarNameValidator carNameValidator;

	public CarNameInput() {
		carNameValidator = new CarNameValidator();
	}

	public List<Car> getCar() {
		String[] carArray;
		do {
			System.out.println(InputMessages.NAME_INPUT);
			String readCars = Console.readLine();
			carArray = readCars.split(",");
		}while(carNameValidator.isInvalidName(carArray));

		return Arrays.stream(carArray)
			.map(name -> new Car(name))
			.collect(Collectors.toList());
	}

}
