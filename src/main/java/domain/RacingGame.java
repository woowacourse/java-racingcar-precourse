/*
 * @(#)RacingGame.java     1.2 2019.12.10
 *
 * Copyright (c) 2019 lxxjn0.
 */

package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자로부터 자동차의 이름을 입력받고 게임을 진행 후 우승자를 출력하는 전반적인 진행을 담당하는 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.2 2019.12.10
 */
public class RacingGame {
	/**
	 * 가장 멀리 전진한 위치(furthestPosition)가 0(출발선)인 경우를 확인하기 위한 상수.
	 */
	private static final int STARTING_LINE = 0;

	/**
	 * 출력 형식을 위해 우승자들 중 첫번째 우승자를 선택할 때 사용하기 위한 상수.
	 */
	private static final int FIRST_OF_WINNER = 0;

	/**
	 * 문자열을 쉼표(,)를 기준으로 자를 때 사용하기 위한 상수.
	 */
	private static final String COMMA_DELIMITER = ",";

	/**
	 * 자동차의 이동한 위치를 표현할 때 사용하기 위한 상수.
	 */
	private static final String MOVING_BAR = "-";

	/**
	 * 실행 결과를 보여줄 때 출력할 메시지 상수.
	 */
	private static final String MOVE_RESULT_MESSAGE = "실행 결과";

	/**
	 * 이름에 대한 위치 결과를 구분하기 위한 상수.
	 */
	private static final String COLON = " : ";

	/**
	 * 모든 자동차 위치가 출발선에 위치할 경우 출력할 메시지 상수.
	 */
	private static final String NO_WINNER_EXIST_MESSAGE = "자동차들이 모두 출발선에 위치해 있습니다. 우승자가 존재하지 않습니다.";

	/**
	 * 최종 우승자들을 출력할 메시지 상수.
	 */
	private static final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

	/**
	 * 사용자의 입력과 관련된 기능들을 담당하는 User 클래스 인스턴스.
	 */
	private User user;

	/**
	 * 생성한 Car 클래스의 객체들을 저장할 List 변수.
	 */
	private List<Car> cars;

	/**
	 * 사용자로부터 자동차의 이름을 받아오는 것부터 우승 결과까지 출력하는 전체 진행을 담당하는 메소드.
	 */
	public void run() {
		user = new User();

		generateCarInstances(user.receiveCarNames());
		moveAndPrintResultForAttemptNumber(user.receiveAttemptNumber());
		printRaceWinner();
	}

	/**
	 * 유효함이 검증된 자동차의 이름으로 Car 클래스 객체를 생성하는 메소드.
	 *
	 * @param carNames 자동차의 이름이 저장된 String list.
	 */
	private void generateCarInstances(List<String> carNames) {
		cars = new ArrayList<>();

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	/**
	 * 입력받은 시도 횟수만큼 이동하면서, 매 번 실행 결과를 출력하는 메소드.
	 *
	 * @param attemptNumber 사용자로부터 입력받은 시도 횟수.
	 */
	private void moveAndPrintResultForAttemptNumber(int attemptNumber) {
		for (int i = 0; i < attemptNumber; i++) {
			moveAllTheCarsOnce();
			printMovingResult();
			System.out.println(" ");
		}
	}

	/**
	 * 모든 자동차들의 이동을 진행시키는 메소드.
	 */
	private void moveAllTheCarsOnce() {
		for (Car car : cars) {
			car.moveAndSetFurthestPosition();
		}
	}

	/**
	 * 자동차들의 진행이 끝나고 실행 결과를 출력하는 메소드.
	 */
	private void printMovingResult() {
		System.out.println(MOVE_RESULT_MESSAGE);
		for (Car car : cars) {
			System.out.println(car.getName() + COLON + toStringMovingBar(car.getPosition()));
		}
	}

	/**
	 * 자동차의 위치만큼 -(하이픈)을 붙여서 문자열로 반환하는 메소드.
	 *
	 * @param position 자동차의 현재 위치.
	 * @return 자동차의 위치만큼 -(하이픈)을 붙여 만든 문자열을 반환.
	 */
	private String toStringMovingBar(int position) {
		StringBuilder movingBar = new StringBuilder();

		for (int i = 0; i < position; i++) {
			movingBar.append(MOVING_BAR);
		}
		return movingBar.toString();
	}

	/**
	 * 우승한 자동차들의 이름을 출력하는 메소드.
	 */
	private void printRaceWinner() {
		if (isAllCarsOnStartingLine()) {
			System.out.println(NO_WINNER_EXIST_MESSAGE);
			return;
		}
		System.out.println(combineWinnerNames() + WINNER_RESULT_MESSAGE);
	}

	/**
	 * 모든 자동차가 이동하지 않고 출발선에 위치해 있는지 여부를 확인하는 메소드.
	 *
	 * @return 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)이 0이면 true 반환.
	 */
	private boolean isAllCarsOnStartingLine() {
		return (Car.getFurthestPosition() == STARTING_LINE);
	}

	/**
	 * 우승한 자동차들의 이름을 하나의 문자열로 합치는 메소드.
	 *
	 * @return 우승한 자동차들의 이름이 하나로 합쳐진 문자열을 반환.
	 */
	private String combineWinnerNames() {
		StringBuilder winnerNames = new StringBuilder();
		List<Car> winners = selectRaceWinner();
		
		winnerNames.append(winners.get(FIRST_OF_WINNER).getName());
		for (int i = FIRST_OF_WINNER + 1; i < winners.size(); i++) {
			winnerNames.append(COMMA_DELIMITER + " ").append(winners.get(i).getName());
		}
		return winnerNames.toString();
	}

	/**
	 * Car 클래스에 저장된 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)과 위치가 동일한 자동차들을 반환하는 메소드.
	 *
	 * @return 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)과 위치가 동일한 자동차 객체 List를 반환.
	 */
	private List<Car> selectRaceWinner() {
		List<Car> winners = new ArrayList<>();

		for (Car car : cars) {
			if (car.getPosition() == Car.getFurthestPosition()) {
				winners.add(car);
			}
		}
		return winners;
	}
}
