package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.service.RaceManager;
import racingcar.view.Commentator;
import racingcar.view.InputManager;

public class RaceController {
	private final RaceManager raceManager;
	private final Commentator commentator;
	private final InputManager inputManager;

	public RaceController() {
		raceManager = new RaceManager();
		commentator = new Commentator();
		inputManager = new InputManager();
	}

	public void start() {
		List<Car> cars = inputManager.getCars();
		int number = inputManager.getNumberOfRaces();
		startRace(cars, number);
	}

	private void startRace(List<Car> cars, int runtimeNumber) {
		commentator.notifyRaceResult();
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
