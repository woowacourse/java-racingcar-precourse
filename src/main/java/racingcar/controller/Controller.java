package racingcar.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	private final GameService gameService = new GameService();
	private final Parser parser = new Parser();
	private final Validator validator = new Validator();
	private final CarRepository carRepository = new CarRepository();

	public void run() {
		List<String> carNames = parser.parseCarNames(getCarNamesByUserInput());
		saveCars(carNames);
		Game game = new Game(getCarList(), getNumberOfTrial());
		Long gameId = gameService.save(game);
		OutputView.printHead();
		play(game);
		OutputView.printWinners(gameService.getWinners(gameId));
	}

	private void play(Game game) {
		while (!gameService.isEnd(game)) {
			gameService.play(game);
			OutputView.printScore(game.getCars());
		}
	}

	private int getNumberOfTrial() {
		return parser.parseNumberOfTrial(getTrialByUserInput());
	}

	private List<Car> getCarList() {
		return carRepository.findAll();
	}

	private void saveCars(List<String> carNames) {
		for (String carName : carNames) {
			Car car = new Car(carName);
			carRepository.save(car);
		}
	}

	private String getTrialByUserInput() {
		InputView.requestNumberOfTrialMessage();
		String input = Console.readLine();
		try {
			validator.checkNumberOfTrialInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printException(e.getMessage());
			return getTrialByUserInput();
		}
	}

	private String getCarNamesByUserInput() {
		InputView.requestCarNamesMessage();
		String input = Console.readLine();
		try {
			validator.checkCarNamesInput(input);
			return input;
		} catch (IllegalArgumentException e) {
			OutputView.printException(e.getMessage());
			return getCarNamesByUserInput();
		}
	}
}
