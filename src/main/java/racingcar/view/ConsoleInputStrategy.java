package racingcar.view;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ConsoleInputStrategy implements InputStrategy {

	public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String INPUT_TRY_NUMBERS = "시도할 회수는 몇회인가요?";

	@Override
	public Cars getCars() {
		while (true) {
			System.out.println(INPUT_CAR_NAMES);
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
		System.out.println(INPUT_TRY_NUMBERS);
		String inputTryNumber = Console.readLine();
		validateTryNumber(inputTryNumber);
		return Integer.parseInt(inputTryNumber);
	}
}
