package domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
	private ArrayList<Car> carList;
	private Scanner scan;
	private int tryGame;
	private Random random;

	public Game() {
		carList = new ArrayList<Car>();
		scan = new Scanner(System.in);
		random = new Random();

		requestCarName();
		requestTryGame();
	}

	private void requestTryGame() {
		System.out.println("시도할 회수는 몇회인가요?");
		tryGame = scan.nextInt();
	}

	private void requestCarName() {
		String carName;
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
		carName = scan.nextLine();

		divideCarName(carName);
	}

	private void divideCarName(String cars) {
		StringTokenizer carsToken = new StringTokenizer(cars);

		for (int i = 1; carsToken.hasMoreTokens(); i++) {
			carList.add(new Car(carsToken.nextToken(",")));
			System.out.println(carList.get(carList.size() - 1).getName());
		}
	}

	public void startRace() {
		System.out.println("실행 결과");
		for (int i = 0; i < tryGame; i++) {
			moveCar();
			printCarStatus();
		}
	}

	private void moveCar() {
		for (int i = 0; i < carList.size(); i++) {
			if (moveDecision()) {
				carList.get(i).goCar();
			}
		}
	}

	private boolean moveDecision() {
		int randomVal;
		randomVal = random.nextInt(10);
		if (randomVal <= 3) {
			return false;
		}
		return true;
	}

	private void printCarStatus() {
		for (int i = 0; i < carList.size(); i++) {
			System.out.print(carList.get(i).getName() + " : ");
			printPosition(carList.get(i).getPosition());
		}
		System.out.println("\n");
	}

	private void printPosition(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.print("\n");
	}

	public void resultRace() {
		StringBuilder result;

		result = searchWinner(searchMaxPosition());
		System.out.println(result + "가 최종 우승했습니다.");
	}

	private int searchMaxPosition() {
		int maxPosition = 0;
		for (int i = 0; i < carList.size(); i++) {
			if (maxPosition < carList.get(i).getPosition()) {
				maxPosition = carList.get(i).getPosition();
			}
		}
		return maxPosition;
	}

	private StringBuilder searchWinner(int maxPosition) {
		StringBuilder winner = new StringBuilder("");

		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getPosition() == maxPosition) {
				winner.append(carList.get(i).getName()).append(", ");
			}
		}
		winner.delete(winner.length() - 2, winner.length());
		return winner;
	}
}
