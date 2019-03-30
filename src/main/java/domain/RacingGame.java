package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private static Scanner SCANNER = new Scanner(System.in);
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MIN_NAME_LENGTH = 1;

	private List<Car> cars;
	private int count;

	public void runProgram() {
		setUserName();
		setCount();
	}

	//	setUserName : User name을 입력 받고 List에 추가
	private void setUserName() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준을 구분, 이름은 최대 5자까지 가능합니다.)");
		String nameInput = SCANNER.nextLine();

		// isValidUserName

		// make car obejct
		String[] names = nameInput.split(",");
		cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
	}

	//	isValidUserName : 사용 가능한 user name 인지 검사
	public boolean isValidUserName(String nameInput) {
		String[] names = nameInput.split(",");
		for (String name : names) {
			name = name.trim();
			if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
				return false;
			}
		}
		return true;
	}

	//	setCount : 시도할 회수를 입력 받음
	private void setCount() {
		System.out.println("시도할 회수는 몇회인가요? (최대 100회까지 가능)");
		String countInput = SCANNER.nextLine();

		// isValidCount

		count = Integer.parseInt(countInput);
	}

	//	isValidCount : 사용 가능한 count인지

	// startRace : 레이스 시작 (move -> printResult)
	// TODO overloading 을 통해 print 설정 (boolean printFlag) true-> 현재 상황 출력
	public void startRace() {
		for (int i = 0; i < count; i++) {
			moveCars();
			printCurrentSituation();
		}

	}

	public void moveCars() {
		for (Car car : cars) {
			car.move();
		}
	}

	//	printResult : 각 회수의 실행 결과 출력
	public void printCurrentSituation() {
		for (Car car : cars) {
			car.printPosition();
		}
		System.out.println();
	}

	//	printWinner : 우승자 출력
	public void printWinner() {

	}
}
