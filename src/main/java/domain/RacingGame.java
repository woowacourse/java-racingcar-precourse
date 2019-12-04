package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private Scanner sc;
	private List<Car> carList;
	private int racingCount;

	public RacingGame() {
		sc = new Scanner(System.in);
		carList = new ArrayList<>();
	}

	public void startGame() {
		while (true) {
			if (inputCarName()) {
				break;
			}
		}
		while (true) {
			if (inputRacingCount()) {
				break;
			}
		}
		System.out.println("실행 결과");
		for (int i = 0; i < racingCount; i++) {
			startRace();
		}
	}

	private void startRace() {
		for (Car car : carList) {
			car.go();
			System.out.print(car.getName() + ": ");
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean inputCarName() {
		boolean isAvailable = true;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		try {
			String carNames = sc.nextLine();
			if (!splitCarNames(carNames)) {
				System.out.println("잘못된 입력입니다!!!!!!");
				carList = new ArrayList<>();
				isAvailable = false;
			}
		} catch (Exception e) {
			System.out.println("입력 오류입니다!!!!!!");
		}
		return isAvailable;
	}

	private boolean inputRacingCount() {
		boolean isAvailable = true;

		System.out.println("시도할 횟수는 몇회인가요?");
		try {
			racingCount = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("입력 오류입니다!!!!!!");
			isAvailable = false;
		}

		return isAvailable;
	}

	private boolean splitCarNames(String carNames) {
		boolean isAvailable = true;

		String[] splitedCarNames = carNames.split(",");
		if (splitedCarNames.length == 0) {
			return false;
		}

		for (String carName : splitedCarNames) {
			if (carName.length() > 5) {
				isAvailable = false;
				break;
			} else {
				Car car = new Car(carName);
				carList.add(car);
			}
		}

		return isAvailable;
	}
}
