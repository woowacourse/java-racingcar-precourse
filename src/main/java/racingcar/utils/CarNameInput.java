package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;
import racingcar.utils.validator.CarNameValidator;

public class CarNameInput {
	CarNameValidator carNameValidator;

	public CarNameInput() {
		carNameValidator = new CarNameValidator();
	}

	public List<Car> getCar() {
		String[] carArray;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String readCars = Console.readLine();
			carArray = readCars.split(",");
		}while(carNameValidator.isInvalidName(carArray));

		return Arrays.stream(carArray)
			.map(name -> new Car(name))
			.collect(Collectors.toList());
	}

}
