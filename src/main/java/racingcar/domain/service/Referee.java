package racingcar.domain.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;

public class Referee {

	private static final String NEW_LINE = "\n";
	private static final String WINNERS_JOINING_DELIMITER = ", ";

	public String checkRacersPosition(List<Car> racers) {
		String racerStates = mapCarListToState(racers);
		return racerStates + NEW_LINE;
	}

	private String mapCarListToState(List<Car> racers) {
		return racers.stream()
				.map(Car::getState)
				.collect(Collectors.joining(NEW_LINE));
	}

	public String decideWinners(List<Car> racers) {
		int bestRecord = judgeBestRecord(racers);
		return decideWinners(racers, bestRecord);
	}

	private String decideWinners(List<Car> racers, int bestRecord) {
		List<Car> winners = filterWinners(racers, bestRecord);
		return convertCarListToString(winners);
	}

	private String convertCarListToString(List<Car> carList) {
		return carList.stream()
				.map(Car::getName)
				.collect(Collectors.joining(WINNERS_JOINING_DELIMITER));
	}

	private int judgeBestRecord(List<Car> racers) {
		return racers.stream()
				.map(Car::getPosition)
				.max(Comparator.naturalOrder())
				.get();
	}

	private List<Car> filterWinners(List<Car> racers, int bestRecord) {
		return racers.stream()
				.filter(racer -> racer.isWinner(bestRecord))
				.collect(Collectors.toList());
	}
}
