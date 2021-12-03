package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.constant.GameConstants.*;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import racingcar.view.OutputView;

public class RacingGame {

	private final List<RacingCar> participantList = new LinkedList<>();

	public void addParticipants(String participants) {
		StringTokenizer participant = new StringTokenizer(participants, NAME_DISTINGUISH);
		while (participant.hasMoreTokens()) {
			participantList.add(new RacingCar(participant.nextToken()));
		}
	}

	public void run(int rounds) {
		if (rounds == 0) {
			return;
		}
		playGame();
		run(rounds - 1);
	}

	private void playGame() {
		for (RacingCar racingCar : participantList) {
			moveCar(racingCar);
			OutputView.printCarLocation(racingCar);
		}
		System.out.println();
	}

	private void moveCar(RacingCar racingCar) {
		if (pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE) >= STANDARD_OF_MOVEMENT) {
			racingCar.moveCar(MOVING_DISTANCE);
		}
	}

	public void getResult() {
		int winnerDistance = getWinnerScore();
		StringBuilder winner = new StringBuilder();
		for (int i = 0; participantList.get(i).getLocation() == winnerDistance; i++) {
			winner.append(participantList.get(i).getCarName()).append(WINNER_DISTINGUISH);
		}
		winner = new StringBuilder(winner.substring(0, winner.length() - WINNER_DISTINGUISH.length()));
		OutputView.printWinner(winner);
	}

	private int getWinnerScore() {
		participantList.sort((racingCar1, racingCar2) -> racingCar2.getLocation() - racingCar1.getLocation());
		return participantList.get(0).getLocation();
	}

}