package racingcar;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.utils.reader.CarsReader;
import racingcar.utils.reader.RoundReader;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		play();
	}

	private static void play() {
		List<Car> cars = CarsReader.readCars();
		int round = RoundReader.readRound();
		Race race = new Race(cars, round);

		race.start();
		race.printWinners();
	}
}
