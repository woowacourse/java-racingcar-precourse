package racingcar;

import java.util.List;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.model.Car;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		List<Car> cars = InputController.createCars();
		int count = InputController.createCount();
		GameController gameController = new GameController(cars, count);
		gameController.play();
	}
}
