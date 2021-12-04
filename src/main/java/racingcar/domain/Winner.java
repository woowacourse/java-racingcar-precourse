package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.dto.WinnerDto;

public class Winner {
	public static WinnerDto decision(Cars cars) {

		List<String> winnerList = new ArrayList<>();
		Car winner = cars.getCarWithMaxPosition();

		List<Car> carList = cars.getCars();
		for (Car candidateCar : carList) {
			if (candidateCar.isSamePosition(winner.getPosition())) {
				winnerList.add(candidateCar.getName());
			}
		}

		return new WinnerDto(winnerList);
	}

}
