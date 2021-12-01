package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {

	private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준로 구분)";
	private final String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
	private final String VALIDATE_MESSAGE = "숫자만 입력이 가능합니다.";
	private final int START_INCLUSIVE = 0;
	private final int END_INCLUSIVE = 9;
	private final int STANDARD_OF_MOVEMENT = 4;

	private List<Car> participantList = new LinkedList<>();
	private int rounds = 0;

	public void startGame() {
		System.out.println(START_MESSAGE);
		try {
			setGame();
		} catch (IllegalArgumentException error) {
			startGame();
		}
		playRacingGame();
	}

	private void setGame() {
		String participants = readLine();
		String round = readLine();
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
			// 결과 출력
		}
	}

	private void moveCar(Car car) {
		int distance = pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
		if (distance >= STANDARD_OF_MOVEMENT) {
			car.moveCar(distance);
		}
	}

	private void validateNumber(String number) {
		boolean isNumeric = number.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_MESSAGE);
		}
	}
}
