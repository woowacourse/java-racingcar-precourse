package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	private static Scanner SCANNER = new Scanner(System.in);

	private List<Car> cars;
	private int count;
	private int maxPosition = 0;

	public List<Car> getCars() {
		return cars;
	}

	public int getCount() {
		return count;
	}

	public int getMaxPosition() {
		return maxPosition;
	}

	public void runProgram() {
		setUserName();
		setCount();
		startRace();
		printWinners();
		SCANNER.close();
	}

	//	setUserName : User name을 입력 받고 List에 추가
	private void setUserName() {
		String inputtedUserName = "";
		do {
			System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준을 구분, 이름은 최대 5자까지 가능합니다.)");
			inputtedUserName = SCANNER.nextLine();
		}while(Validator.isInvalidUserName(inputtedUserName));

		String[] names = inputtedUserName.split(",");
		cars = new ArrayList<>();
		for (String name : names) {
			name = name.trim();
			cars.add(new Car(name));
		}
	}
	
	//	setCount : 시도할 회수를 입력 받음
	private void setCount() {
		String inputtedCount = "";
		do {
			System.out.println("시도할 회수는 몇회인가요? (최대 100회까지 가능)");
			inputtedCount = SCANNER.nextLine();
		}while(Validator.isInvalidCount(inputtedCount));

		count = Integer.parseInt(inputtedCount);
	}

	// startRace : 레이스 시작 (move -> printResult)
	// TODO overloading 을 통해 print 설정 (boolean printFlag) true-> 현재 상황 출력
	private void startRace() {
		for (int i = 0; i < count; i++) {
			moveCars();
			printCurrentSituation();
		}
	}

	private void moveCars() {
		for (Car car : cars) {
			car.move();
			updateMaxPosition(car.getPosition());
		}
	}
	
	private void updateMaxPosition(int position) {
		maxPosition = Math.max(position, maxPosition);
	}

	//	printResult : 각 회수의 실행 결과 출력
	private void printCurrentSituation() {
		for (Car car : cars) {
			car.printPosition();
		}
		System.out.println();
	}

	//	printWinner : 우승자 출력
	public void printWinners() {
		String result = "";
		for (Car car : findWinners()) {
			result += car.getName() + ", ";
		}
		System.out.println(result.substring(0, result.length() - 2) + "가 최종 우승했습니다.");
	}
	
	public List<Car> findWinners(){
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if(car.getPosition() == maxPosition) {
				winners.add(car);
			}
		}
		return winners;
	}
}
