package racingcar.domain;

public class Track {
	private final Cars cars;

	public Track(Cars cars) {
		this.cars = cars;
	}

	public void play() {
		cars.move();
	}

	public Round makeRoundResult() {
		return new Round(cars);
	}
}
