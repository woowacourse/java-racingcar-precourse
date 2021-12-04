package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	public static List<String> decision(Cars cars) {

		List<String> winnerList = new ArrayList<>();
		Car winner = cars.getCarWithMaxPosition();

		List<Car> carList = cars.getCars();
		for (Car candidateCar : carList) {
			if (candidateCar.isSamePosition(winner.getPosition())) {
				winnerList.add(candidateCar.getName());
			}
		}
		return winnerList;
	}

}
