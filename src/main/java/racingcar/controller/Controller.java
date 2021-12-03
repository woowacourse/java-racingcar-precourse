package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	private GameService gameService;
	private Parser parser = new Parser();
	private OutputView outputView = new OutputView();

	public void run() {
		List<Car> cars = setGame();
		List<Car> winners = gameService.play();
		printGameResult(cars, winners);
	}

	private void printGameResult(List<Car> cars, List<Car> winners) {
		outputView.printResults(cars);
		outputView.printWinners(winners);
	}

	private List<Car> setGame() {
		List<Car> cars = getCarsByUserInput();
		int trial = getTrialByUserInput();
		gameService = new GameService(trial, cars);
		return cars;
	}

	private int getTrialByUserInput() {
		InputView.requestNumberOfTrialMessage();
		int trial = parser.parseNumberOfTrial(Console.readLine());
		return trial;
	}

	private List<Car> getCarsByUserInput() {
		InputView.requestCarNamesMessage();
		try {
			List<String> carNames = parser.parseCarNames(Console.readLine());
			List<Car> cars = getCars(carNames);
			return cars;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarsByUserInput();
		}
	}

	private List<Car> getCars(List<String> carNames) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < carNames.size(); i++) {
			carList.add(new Car(carNames.get(i)));
		}
		return carList;
	}
}
