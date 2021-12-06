package racingcar.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;

public class Referee {

	private static final String NEW_LINE = "\n";

	public String checkRacersPosition(List<Car> racers) {
		String racerStates = mapCarListToState(racers);
		return racerStates + NEW_LINE;
	}

	private String mapCarListToState(List<Car> racers) {
		return racers.stream()
				.map(Car::getState)
				.collect(Collectors.joining(NEW_LINE));
	}
}
