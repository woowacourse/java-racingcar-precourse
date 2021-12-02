package racingcar;

import racingcar.domain.CarRepository;
import racingcar.view.InputView;

public class Game {
	public void run() {
		CarRepository carRepository = new CarRepository();
		carRepository.createCars(InputView.inputCarNames());

	}
}
