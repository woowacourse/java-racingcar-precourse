/*
 * @(#)Game.java
 *
 * 버전 : 1.0
 *
 * 날짜 : 2019.12.10
 */
package domain;
/**
 * 우아한테크코스 프리코스 2주차 자동차 경주 게임
 * 설명 : 게임을 진행하기 위한 Game 클래스
 *
 * @version 1.0     2019.12.10
 * @author 최재우
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Game {
	private final static int END_WORD = 2;
	private final static int SCORE_STANDARD = 3;
	private final static int NAME_STANDARD = 5;
	private final static int RANDOM_LIMIT = 10;
	private ArrayList<Car> carList;
	private Scanner scan;
	private int tryGame;
	private Random random;

	public Game() {
		carList = new ArrayList<Car>();
		scan = new Scanner(System.in);
		random = new Random();
	}

	public void startGame() {
		requestCarName();

		while (true) {
			try {
				requestTryGame();
				break;
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요");
				scan = new Scanner(System.in);
			}
		}
	}

	private void requestTryGame() {
		System.out.println("시도할 회수는 몇회인가요?");
		tryGame = scan.nextInt();
	}

	private void requestCarName() {
		String carName;
		//제대로 된 이름이 입력될 때까지 반복
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
			carName = scan.nextLine();
		} while (divideCarName(carName));
	}

	//자동차 이름 분리하여 리스트에 저장하는 메소드
	private boolean divideCarName(String cars) {
		StringTokenizer carsToken = new StringTokenizer(cars);
		for (int i = 1; carsToken.hasMoreTokens(); i++) {
			carList.add(new Car(carsToken.nextToken(",")));
			if (carList.get(carList.size() - 1).getName().length() > NAME_STANDARD) {     //입력한 자동차 이름이 5글자 이상일 시
				System.out.println("제대로 된 자동차 이름을 입력하세요");
				scan = new Scanner(System.in);
				carList.clear();
				return true;
			}
		}
		return false;
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
		randomVal = random.nextInt(RANDOM_LIMIT);
		if (randomVal <= SCORE_STANDARD) {
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

	//Car 객체들의 가장 높은 Position 값 탐색하는 메소드
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
			if (carList.get(i).getPosition() == maxPosition) {                //가장 높은 Position과 같은 Position Car 객체 탐색
				winner.append(carList.get(i).getName()).append(", ");
			}
		}
		winner.delete(winner.length() - END_WORD, winner.length());
		return winner;
	}
}
