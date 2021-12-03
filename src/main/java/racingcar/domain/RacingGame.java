package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.*;
import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.constant.GameConstants.*;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class GameParticipant {

	private final List<RacingCar> participantList = new LinkedList<>();
	private int rounds = 0;

	public void startGame() {
		initialize();
		System.out.println(GAME_RESULT_MESSAGE);
		for (int i = 0; i < rounds; i++) {
			playRacingGame();
		}
		printGameResult();
	}

	private void initialize() {
		enterPlayer();
		enterRound();
		System.out.println();
	}

	private void enterPlayer() {
		try {
			System.out.println(START_MESSAGE);
			String participants = readLine();
			setPlayers(participants);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			enterPlayer();
		}
	}

	private void enterRound() {
		try {
			System.out.println(TRY_MESSAGE);
			String round = readLine();
			validateNumber(round);
			setRounds(round);
		} catch (IllegalArgumentException error) {
			enterRound();
		}
	}

	private void setPlayers(String participants) {
		StringTokenizer participant = new StringTokenizer(participants, NAME_DISTINGUISH);
		while (participant.hasMoreTokens()) {
			participantList.add(new RacingCar(participant.nextToken()));
		}
	}

	private void setRounds(String round) {
		this.rounds = Integer.parseInt(round);
	}

	private void playRacingGame() {
		for (RacingCar racingCar : participantList) {
			moveCar(racingCar);
			printCarLocation(racingCar);
		}
		System.out.println();
	}

	private void moveCar(RacingCar racingCar) {
		if (pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= STANDARD_OF_MOVEMENT) {
			racingCar.moveCar(MOVING_DISTANCE);
		}
	}

	private void printCarLocation(RacingCar racingCar) {
		System.out.print(racingCar.getCarName() + " : ");
		for (int i = 0; i < racingCar.getLocation(); i++) {
			System.out.print(CAR_SHAPE);
		}
		System.out.println();
	}

	private void printGameResult() {
		int winnerDistance = getWinnerScore();
		StringBuilder winner = new StringBuilder();
		for (int i = 0; participantList.get(i).getLocation() == winnerDistance; i++) {
			winner.append(participantList.get(i).getCarName()).append(WINNER_DISTINGUISH);
		}
		winner = new StringBuilder(winner.substring(0, winner.length() - WINNER_DISTINGUISH.length()));
		System.out.println(WINNER_MESSAGE + winner);
	}

	private int getWinnerScore() {
		participantList.sort((racingCar1, racingCar2) -> racingCar2.getLocation() - racingCar1.getLocation());
		return participantList.get(0).getLocation();
	}

	private void validateNumber(String number) {
		boolean isNumeric = number.matches(REGEX_EXPRESSION_OF_NUMBER);
		if (!isNumeric) {
			throw new IllegalArgumentException(VALIDATE_MESSAGE);
		}
	}

	public void addParcitipantCar(String input) {
	}
}