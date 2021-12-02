package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RacingGameController {
	private final RacingGameView racingGameView;
	private List<Car> carList;
	private int repetitionNumber;

	public RacingGameController() {
		racingGameView = RacingGameView.getRacingGameView();
		carList = new ArrayList<>();
	}

	public void startGame() {
		carList =
			racingGameView.getCarNames()
				.stream()
				.map(Car::new)
				.collect(Collectors.toList());
		repetitionNumber = racingGameView.getRepetitionNumber();
	}
}
