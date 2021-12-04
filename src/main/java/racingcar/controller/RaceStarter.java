package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.service.Converter;
import racingcar.service.RaceManager;
import racingcar.service.Validator;
import racingcar.view.ConsoleView;

public class RaceStarter {
	private RaceManager raceManager;
	private ConsoleView view;

	public RaceStarter() {
		raceManager = new RaceManager();
		view = new ConsoleView();
	}

	public void start() {
		List<Car> cars = view.getCarNames();
		int number = view.getRuntimeNumber();
		// startRace(cars, number);
	}

	private void startRace(List<Car> cars, int runtimeNumber) {
		for(int i = 0; i < runtimeNumber; i++) {
			raceManager.move(cars);
			// TODO : 실행 결과 알려주기
		}
	}
}
