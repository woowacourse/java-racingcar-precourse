package racingcar;

import static constant.RacingCarGameMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Referee {

	public String sayWinnerNames(List<Car> carList) {
		List<Car> winnerList = pickTheWinner(carList);
		String winnerNames = winnerList.get(0).getName();

		for (int i = 1; i < winnerList.size(); i++) {
			winnerNames += DELIMITER + SPACE + winnerList.get(i).getName();
		}

		return winnerNames;
	}

	public static List<Car> pickTheWinner(List<Car> carList) {
		List<Car> winnerList = new ArrayList<>();
		int winnerPosition = Car.maxPosition(carList);

		for (Car car : carList) {

			if (car.isSamePosition(winnerPosition)) {
				winnerList.add(car);
			}

		}

		return winnerList;
	}
}
