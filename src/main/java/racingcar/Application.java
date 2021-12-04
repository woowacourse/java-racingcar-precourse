package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Cars;
import racingcar.utils.CarUtils;
import racingcar.view.InputView;

public class Application {

	public static void main(String[] args) {
		// TODO 구현 진행
		Cars cars;
		int numberOfAttempts;

		cars = CarUtils.makeCars(InputView.writeCarNames());
		numberOfAttempts = InputView.writeNumberOfAttempts();
		GameController.playRacing(cars, numberOfAttempts);
	}
}
