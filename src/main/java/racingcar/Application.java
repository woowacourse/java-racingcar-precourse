package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.input.CarList;
import racingcar.input.Trial;

public class Application {

	private static List<Car> cars;
	private static int trial;

	public static void main(String[] args) {
		// TODO 구현 진행
		setInputData();
		gameStart();
	}

	private static void gameStart() {
		System.out.println("실행 결과");
		while (--trial >= 0) {
			gameLoop();
		}
	}

	private static void gameLoop() {
		for (Car car : cars) {
			car.moveOrStop();
			car.printPosition();
		}
		System.out.println();
	}

	private static void setInputData() {
		cars = getCarNameInput();
		trial = getTrialInput();
	}

	private static int getTrialInput() {
		System.out.println("시도 횟수를 입력하세요.");
		return Trial.input();
	}

	private static List<Car> getCarNameInput() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return CarList.input();
	}
}
