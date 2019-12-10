package com.woowacourse.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @author KSKIM
 * @since 2019-12-09
 */
public class Winner {
	private List<Car> cars;

	public Winner(List<Car> cars) {
		this.cars = cars;
	}

	public List<String> getWinnerNames() {
		return cars.stream()
				.map(Car::getName)
				.collect(Collectors.toList());
	}
}
