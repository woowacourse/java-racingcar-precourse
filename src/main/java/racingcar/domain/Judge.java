package racingcar.domain;

import static racingcar.domain.Car.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;

public enum Judge {
	JUDGE_INSTANCE;

	public List<String> judging(Car[] cars) {
		List<Car> carList = Lists.list(cars);
		sortingByPosition(carList);

		return getRaceWinnerList(carList);
	}

	private List<String> getRaceWinnerList(List<Car> carList) {
		int max = carList.get(0).getPosition();

		List<String> winnerList = new ArrayList<>();
		for (Car car : carList) {
			if (max == car.getPosition()) {
				winnerList.add(car.getName());
			}
		}
		return winnerList;
	}
}
