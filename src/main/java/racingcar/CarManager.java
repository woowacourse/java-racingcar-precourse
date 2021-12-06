package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
	public List<Car> generate(String carNames) {
		//TODO 차 입력 예외처리 및 유효성 검사 필요
		return Arrays.stream(carNames.split(","))
			.map(Car::new)
			.collect(Collectors.toList());
	}

	public List<Car> getWinner(List<Car> carList) {
		int maxPositionValue = getMaxPositionValue(carList);
		List<Car> winnerCarList = new ArrayList<>();

		carList.forEach(car -> {
			if (car.getPosition() == maxPositionValue) {
				winnerCarList.add(car);
			}
		});

		return winnerCarList;
	}

	private int getMaxPositionValue(List<Car> carList) {
		return Collections.max(carList
			.stream()
			.map(Car::getPosition)
			.collect(Collectors.toList()));
	}
}
