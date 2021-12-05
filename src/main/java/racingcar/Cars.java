package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Cars {
	public static final String DELIMITER = ",";
	public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private List<Car> cars = new ArrayList<>();

	public void createCars() {
		String[] carNames = inputCarNames();

		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
	}

	private static String[] inputCarNames() {
		System.out.println(INPUT_CAR_NAMES);
		return Console.readLine().split(DELIMITER);
	}

	public void move() {
		cars.stream().forEach(Car::move);
	}

	public void showState() {
		cars.stream().forEach(System.out::println);
		System.out.println();
	}
}
