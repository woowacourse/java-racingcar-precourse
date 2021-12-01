package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {

	private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준로 구분)";
	private static final String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String VALIDATE_MESSAGE = "숫자만 입력이 가능합니다.";
	private static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String CAR_SHAPE = "-";

	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;
	private static final int STANDARD_OF_MOVEMENT = 4;

	private List<Car> participantList = new LinkedList<>();
	private int rounds = 0;

	public void startGame() {
		try {
			setGame();
		} catch (IllegalArgumentException error) {
			startGame();
		}
		System.out.println(GAME_RESULT_MESSAGE);
		for (int i = 0; i < rounds; i++) {
			playRacingGame();
		}
		printGameResult();
	}

	private void setGame() {
		System.out.println(START_MESSAGE);
		String participants = readLine();
		System.out.println(TRY_MESSAGE);
		String round = readLine();
		System.out.println();
		validateNumber(round);
		updateGameInformation(participants, Integer.parseInt(round));
	}

	private void updateGameInformation(String participants, int round) {
		StringTokenizer participant = new StringTokenizer(participants, ",");
		while (participant.hasMoreTokens()) {
			participantList.add(new Car(participant.nextToken()));
		}
		this.rounds = round;
	}

	private void playRacingGame() {
		for (Car car : participantList) {
			moveCar(car);
			printCarLocation(car);
		}
		System.out.println();
	}

	private void moveCar(Car car) {
		int distance = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (distance >= STANDARD_OF_MOVEMENT) {
			car.moveCar(distance);
		}
	}

	private void printCarLocation(Car car) {
		System.out.print(car.getCarName() + " : ");
		for (int i = 0; i < car.getLocation(); i++) {
			System.out.print(CAR_SHAPE);
		}
		System.out.println();
	}

	private void printGameResult() {
		participantList.sort((car1, car2) -> car2.getLocation() - car1.getLocation());
		for (Car car : participantList) {
			System.out.println(car.getLocation());
		}
	}

	private void validateNumber(String number) {
		boolean isNumeric = number.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_MESSAGE);
		}
	}

}