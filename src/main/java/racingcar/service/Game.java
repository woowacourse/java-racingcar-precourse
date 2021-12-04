package racingcar.service;

import static racingcar.util.Constant.*;

import java.util.LinkedList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.User;

public class Game {

	List<Car> participant;
	List<Car> winner;
	User user;

	public Game(User user) {
		this.user = user;
	}

	public void start() {
		setGame();
		repeatGame(user.replyMoveCount());
		setWinner();
	}

	private void setWinner() {
		int winnerPosition = WINNER_MIN;
		for (Car car:
			 participant) {
			if (car.getPosition() > winnerPosition) {
				winner = new LinkedList<>();
				winner.add(car);
				winnerPosition = car.getPosition();
			} else if (car.getPosition() == winnerPosition) {
				winner.add(car);
			}
		}
	}

	private void printWinner() {

	}

	private void setGame() {
		setParticipant(user.replyCars());
	}

	private void setParticipant(String[] cars) {
		participant = new LinkedList<>();
		for (String car :
			cars) {
			participant.add(new Car(car));
		}
	}

	private void repeatGame(int moveCount) {
		System.out.println(GAME_RESULT);
		for (int current = 0; current < moveCount; current++) {
			proceedGame();
			printParticipant();
		}
	}

	private void proceedGame() {
		for (Car car:
			 participant) {
			car.move();
		}
	}

	private void printParticipant() {
		for (Car car:
			participant) {
			System.out.println(car.toString());
		}
		System.out.println();
	}
}
