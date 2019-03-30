package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 자동차 게임 진행
 * @version 1.00 19.03.31
 * @author ep1stas1s
 */
public class RacingGame {
	private static Scanner SCANNER = new Scanner(System.in);

	private List<Car> cars;
	private int count;
	private int maxPosition = 0;

	public void runProgram() {
		setUserName();
		setCount();
		startRace();
		printWinners();
		SCANNER.close();
	}

	private void setUserName() {
		String inputtedUserName = "";
		do {
			System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준을 구분, 이름은 최대 5자까지 가능합니다.)");
			inputtedUserName = SCANNER.nextLine();
		} while (Validator.isInvalidUserName(inputtedUserName));

		String[] names = inputtedUserName.split(",");
		cars = new ArrayList<>();
		for (String name : names) {
			name = name.trim();
			cars.add(new Car(name));
		}
	}

	private void setCount() {
		String inputtedCount = "";
		do {
			System.out.println("시도할 회수는 몇회인가요? (최대 999회까지 가능)");
			inputtedCount = SCANNER.nextLine();
		} while (Validator.isInvalidCount(inputtedCount));

		count = Integer.parseInt(inputtedCount);
	}

	/**
	 * car를 움직이고 상태를 출력하는 과정을 정해진 회수만큼 실행
	 */
	private void startRace() {
		for (int i = 0; i < count; i++) {
			moveCars();
			printCurrentSituation();
		}
	}

	/**
	 * 각 car를 움직이고, 가장 많이 간 car의 position을 갱신
	 */
	private void moveCars() {
		for (Car car : cars) {
			car.move();
			updateMaxPosition(car.getPosition());
		}
	}

	private void updateMaxPosition(int position) {
		maxPosition = Math.max(position, maxPosition);
	}

	private void printCurrentSituation() {
		for (Car car : cars) {
			car.printPosition();
		}
		System.out.println();
	}

	public void printWinners() {
		String result = "";
		for (Car car : findWinners()) {
			result += car.getName() + ", ";
		}
		System.out.println(result.substring(0, result.length() - 2) + "가 최종 우승했습니다.");
	}

	private List<Car> findWinners() {
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.collect(Collectors.toList());
	}
}
