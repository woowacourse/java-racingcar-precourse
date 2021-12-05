package racingcar.domain;

import java.util.List;

import racingcar.utils.reader.CarsReader;
import racingcar.utils.reader.RoundReader;

public class RacingCarGame {
	public void play() {
		List<Car> cars = CarsReader.readCars();
		int round = RoundReader.readRound();
		Race race = new Race(cars, round);

		race.start();
		race.printWinners();
	}
}
