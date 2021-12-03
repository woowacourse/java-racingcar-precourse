package racingcar;

public class CarRacingGame {
	private Cars cars;
	private int tryCount;

	public void play() {
		cars = createCars();
		tryCount = readTryCount();
	}

	private Cars createCars() {
		try {
			return new Cars(InputView.readCarNames());
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return createCars();
		}
	}

	private int readTryCount() {
		return InputView.readTryCount();
	}
}
