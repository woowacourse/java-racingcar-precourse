package racingcar.domain;

import static racingcar.domain.Car.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Judge {
	JUDGE_INSTANCE;

	public List<String> judging(Car[] cars) {
		return getRaceWinnerList(Arrays.asList(cars));
	}

	private List<String> getRaceWinnerList(List<Car> carList) {
		sortingByPosition(carList);

		int max = carList.get(0).getPosition();

		return carList.stream()
			.filter(s-> s.getPosition()==max)
			.map(s-> s.getName())
			.collect(Collectors.toList());
	}
}
