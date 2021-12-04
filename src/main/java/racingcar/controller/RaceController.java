package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.service.RaceManager;
import racingcar.view.Commentator;

public class RaceController {
	private final RaceManager raceManager;
	private final Commentator commentator;

	public RaceController() {
		raceManager = new RaceManager();
		commentator = new Commentator();
	}

	public void start() {
		List<Car> cars = commentator.getCarNames();
		int number = commentator.getRuntimeNumber();
		startRace(cars, number);
	}

	private void startRace(List<Car> cars, int runtimeNumber) {
		commentator.printRaceStart();
		for(int i = 0; i < runtimeNumber; i++) {
			raceManager.moveCars(cars);
			commentator.notifyCarsStatement(cars);
		}
		endRace(cars);
	}

	private void endRace(List<Car> cars) {
		List<String> winnerNames = raceManager.getWinners(cars);
		commentator.notifyWinners(winnerNames);
	}
}
