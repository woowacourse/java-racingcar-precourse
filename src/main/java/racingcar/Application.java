package racingcar;

import racingcar.car.CarController;
import racingcar.game.RacingGameController;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		CarController carController = new CarController();
		RacingGameController racingGameController = new RacingGameController(carController.createCars());
		racingGameController.run();
	}
}
