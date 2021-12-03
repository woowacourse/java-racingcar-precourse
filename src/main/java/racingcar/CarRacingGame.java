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
		try {
			int tryCount = InputView.readTryCount();
			TryCountValidator.validate(tryCount);
			return tryCount;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return readTryCount();
		}
	}
}
