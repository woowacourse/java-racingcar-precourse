package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
	private final Cars cars;
	private final int trialCount;
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();

	public RacingCarController() {
		this.cars = new Cars(inputView.getCarNames());
		this.trialCount = inputView.getTrialCount();
	}

	public void run() {
		this.play(trialCount);
		this.showWinners();
	}

	private void play(int trialCount) {
		RandomForward randomForward = new RandomForward();
		outputView.printResultMessage();

		for (int count = 0; count < trialCount; count++) {
			this.cars.forward(randomForward);
			outputView.printCarsPosition(this.cars);
		}
	}

	private void showWinners() {
		List<String> winners = this.findWinners();
		outputView.printWinners(winners);
	}

	private List<String> findWinners() {
		List<String> winners = new ArrayList<>();
		int farthestPosition = this.getFarthestPosition();

		for (Car car : this.cars.getCars()) {
			if (car.getPosition() == farthestPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

	private int getFarthestPosition() {
		int farthestPosition = 0;

		for (Car car : this.cars.getCars()) {
			farthestPosition = Math.max(farthestPosition, car.getPosition());
		}
		return farthestPosition;
	}
}
