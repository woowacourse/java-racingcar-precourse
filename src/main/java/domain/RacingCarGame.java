/*
 * 클래스명 : RacingCarGame
 * 
 * version : 0.3
 * 
 * 날짜 : 2019.12.08
 * 
 * 작성자 : ParkDooWon
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptionhandler.ExceptionHandler;

public class RacingCarGame {
	private static final String QUESTION_TO_GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String QUESTION_TO_GET_TRIES = "시도할 회수는 몇 회인가요?";
	private static final String RESULT = "실행 결과";
	private static final String IS_WINNER = "이(가) 최종 우승했습니다.";
	private static final String COMMA = ",";
	private static final char SHAPE = '-';
	private String numOfTries;
	private String carNamesDividedByComma;
	private String carNames[];
	private List<Car> cars = new ArrayList<>();
	private List<String> winners = new ArrayList<>();
	private ExceptionHandler exception = new ExceptionHandler();
	static final Scanner input = new Scanner(System.in);

	public void startGame() {
		getCarNames();
		getTries();
		System.out.println('\n' + RESULT);
		for (int i = 0; i < Integer.valueOf(numOfTries); i++) {
			moveCar();
			printPosition();
			System.out.print('\n');
		}
		findWinners();
		printWinners();
	}

	private void getCarNames() {
		System.out.println(QUESTION_TO_GET_CAR_NAMES);
		do {
			carNamesDividedByComma = input.nextLine();
		} while (exception.checkNameRange(carNamesDividedByComma) || exception.isDuplicated()
					|| exception.isNothing());
		carNames = carNamesDividedByComma.split(COMMA);
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	private void getTries() {
		System.out.println(QUESTION_TO_GET_TRIES);
		do {
			numOfTries = input.nextLine();
		} while (exception.isNumber(numOfTries) || exception.checkTryRange());
	}

	private void moveCar() {
		for (Car car : cars) {
			car.makeRandomNum();
			car.move();
		}
	}

	private void printPosition() {
		for (Car car : cars) {
			car.printCarPosition(SHAPE);
		}
	}

	private void findWinners() {
		int winnerPosition = 0;
		for (Car car : cars) {
			winnerPosition = car.findWinnerPosition(winnerPosition);
		}
		for (Car car : cars) {
			if (car.isWinner(winnerPosition)) {
				winners.add(car.getWinnerName());
			}
		}
	}
	
	private void printWinners() {
		for (int i = 0; i < winners.size(); i++) {
			System.out.print(winners.get(i));
			if (i < winners.size() - 1) {
				System.out.print(COMMA + " ");
			} else if (i == winners.size() - 1) {
				System.out.print(IS_WINNER);
			}
		}
	}
}
