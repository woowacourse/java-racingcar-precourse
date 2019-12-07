package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Method {

	Car[] cars;
	String[] names;
	Random rd = new Random();
	Scanner scan = new Scanner(System.in);

	public void SetCarName() {
		String car;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
			car = scan.next();
		} while (SplitCarName(car));
		InputRunCount();
	}

	private boolean SplitCarName(String car) {
		names = car.split(",");
		cars = new Car[names.length];
		for (int i = 0; i < names.length; i++) {
			if (!CheckStringLength(names[i])) {
				System.out.println("5자를 초과하셨습니다");
				return true;
			}
			cars[i] = new Car(names[i]);
		}
		return false;
	}

	private void InputRunCount() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int runCount = scan.nextInt();
		printResult(runCount);
	}

	private void printResult(int runCount) {
		System.out.println();
		System.out.println();
		System.out.println("실행 결과");
		for (int i = 0; i < runCount; i++) {
			runResult();
		}
		checkWinner();

	}

	private boolean CheckStringLength(String carName) {
		if (carName.length() < 6)
			return true;
		return false;
	}

	public boolean checkForward() {
		if (RandomNumber() < 4)
			return false;
		return true;
	}

	private int RandomNumber() {
		return rd.nextInt(9) + 1;
	}

	public void runResult() {
		for (int i = 0; i < cars.length; i++) {
			if (checkForward())
				cars[i].setPosition(checkForward());
			printCarPosition(i);
		}
		System.out.println();
	}

	private void printCarPosition(int index) {
		System.out.print(cars[index].getName() + ":");
		for (int i = 0; i < cars[index].getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void checkWinner() {
		int max = cars[0].getPosition(), winner = 0;
		for (int i = 1; i < cars.length; i++) {
			if (max < cars[i].getPosition()) {
				max = cars[i].getPosition();
				winner = i;
			}
		}
		checkTie(max, winner);
	}

	private void checkTie(int max, int winner) {
		ArrayList<String> winners = new ArrayList<String>();
		winners.add(cars[winner].getName());
		for (int i = 0; i < cars.length; i++) {
			if (max == cars[i].getPosition() && winner != i)
				winners.add(cars[i].getName());
		}
		printWinner(winners);
	}

	

}
