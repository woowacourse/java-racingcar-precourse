package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarGameRunner {
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;

	public void startRace(final List<Car> cars, final int moveCount) {
		for (int round = 0; round < moveCount; round++) {
			cars.forEach(car -> car.move(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)));
		}
	}
}
