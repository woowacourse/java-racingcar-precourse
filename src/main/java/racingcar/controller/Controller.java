package racingcar.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
	private GameService gameService = new GameService();
	private Parser parser = new Parser();
	private OutputView outputView = new OutputView();
	private Validator validator = new Validator();
	private CarRepository carRepository = new CarRepository();

	public void run() {
		List<String> carNames = parser.parseCarNames(getCarNamesByUserInput());
		saveCars(carNames);
		List<Car> cars = carRepository.findAll();
		int trial = parser.parseNumberOfTrial(getTrialByUserInput());
		Long gameId = gameService.save(new Game(cars, trial));
		List<CarDto> carDtos = gameService.play(gameId);
		outputView.printResults(carDtos);
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
			outputView.printException(e.getMessage());
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
			outputView.printException(e.getMessage());
			return getCarNamesByUserInput();
		}
	}
}
