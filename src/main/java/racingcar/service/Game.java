package racingcar.service;

import java.util.LinkedList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.User;

public class Game {

	List<Car> participant;
	User user;
	int moveCount;

	public Game(User user) {
		this.user = user;
	}

	public void start() {
		setGame();
	}

	public void setGame() {
		setParticipant(user.replyCars());
		setMoveCount(user.replyMoveCount());
	}

	private void setMoveCount(int replyMoveCount) {
		moveCount = replyMoveCount;
	}

	private void setParticipant(String[] cars) {
		participant = new LinkedList<>();
		for (String car :
			cars) {
			participant.add(new Car(car));
		}
	}
}
