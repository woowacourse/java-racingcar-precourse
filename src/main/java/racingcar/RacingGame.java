package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {

	private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준로 구분)";
	private static final String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String VALIDATE_MESSAGE = "[ERROR] 숫자만 입력이 가능합니다.";
	private static final String GAME_RESULT_MESSAGE = "실행 결과";
	private static final String WINNER_MESSAGE = "최종 우승자 : ";
	private static final String CAR_SHAPE = "-";
	private static final String WINNER_DISTINGUISH = ", ";
	private static final String END_CHECKER = ":";

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
		int winnerDistance = participantList.get(0).getLocation();
		String winner = "";
		for (int i = 0; participantList.get(i).getLocation() == winnerDistance; i++) {
			winner += participantList.get(i).getCarName() + WINNER_DISTINGUISH;
		}
		winner = winner.substring(0, winner.length() - WINNER_DISTINGUISH.length());
		System.out.println(WINNER_MESSAGE + winner);
	}

	private String isWinner(Car car, int distance) {
		if (car.getLocation() == distance) {
			return car.getCarName();
		}
		return END_CHECKER;
	}

	private void validateNumber(String number) {
		boolean isNumeric = number.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_MESSAGE);
		}
	}

}