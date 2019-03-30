package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private static Scanner SCANNER = new Scanner(System.in);

	private List<Car> cars;
	private int count;

	public void runProgram() {
		setUserName();
		setCount();
	}

	//	setUserName : User name을 입력 받고 List에 추가
	private void setUserName() {
		System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준을 구분)");
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

	//	setCount : 시도할 회수를 입력 받음
	private void setCount() {
		System.out.println("시도할 회수는 몇회인가요? (최대 100회까지 가능)");
		String countInput = SCANNER.nextLine();

		// isValidCount

		count = Integer.parseInt(countInput);
	}

	//	isValidCount : 사용 가능한 count인지

	//	printResult : 각 회수의 실행 결과 출력
	public void printResult() {
		for (Car car : cars) {
			car.printPosition();
		}
	}

	//	printWinner : 우승자 출력
	public void printWinner() {
		
	}
}
