package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	/**
	 * position이 가장클 경우 maxPosition을 갱신
	 * @param position car의 위치
	 */
	private void updateMaxPosition(int position) {
		maxPosition = Math.max(position, maxPosition);
	}

	/**
	 * 각 car의 현재 position을 막대바로 출력
	 */
	private void printCurrentSituation() {
		for (Car car : cars) {
			car.printPosition();
		}
		System.out.println();
	}

	/**
	 * race에서 우승한 사람을 출력
	 */
	public void printWinners() {
		String result = "";
		for (Car car : findWinners()) {
			result += car.getName() + ", ";
		}
		System.out.println(result.substring(0, result.length() - 2) + "가 최종 우승했습니다.");
	}

	/**
	 * race에서 우승한 사람을 찾아 List<Car>로 반환
	 * @return 1명 이상의 우승한 Car
	 */
	private List<Car> findWinners() {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}
		return winners;
	}
}
