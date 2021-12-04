package racingcar.service;

import java.util.LinkedList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.User;

public class Game {

	List<Car> participant;
	User user;

	public Game(User user) {
		this.user = user;
	}

	public void start() {
		setGame();
		int moveCount = user.replyMoveCount();
	}

	public void setGame() {
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
		for (int current = 0; current < moveCount; current++) {
			proceedGame();
		}
	}

	private void proceedGame() {

	}

	private void printParticipant() {

	}
}
