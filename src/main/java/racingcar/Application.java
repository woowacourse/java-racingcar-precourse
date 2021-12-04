package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.input.CarList;

public class Application {

	private static List<Car> cars = new ArrayList<>();

	public static void main(String[] args) {
		// TODO 구현 진행

		getCarNameInput();

		for (Car car : cars) {
			System.out.println("car = " + car);
		}
	}

	private static void getCarNameInput() {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		cars = CarList.input();
	}
}
