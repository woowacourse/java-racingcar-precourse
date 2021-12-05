package racingcar;

import java.util.List;

public interface CarGameRunner {
	void startRace(List<Car> cars, int moveCount);

	void printWinner();
}
