package racingcar;

public class CarRacingGame {
	private Cars cars;

	public void play() {
		cars = createCars();
	}

	private Cars createCars() {
		try {
			return new Cars(InputView.readCarNames());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return createCars();
		}
	}
}
