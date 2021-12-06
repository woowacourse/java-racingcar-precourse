package model;

public class RacingCarGame {
	private RacingCars racingCars;
	private RaceCount raceCount;

	public RacingCarGame(String[] racingCarNames) {
		racingCars = new RacingCars(racingCarNames);
	}

	public void passRaceCount(int count) {
		raceCount = new RaceCount(count);
	}

	public void playRacingCarGame() {
		racingCars.moveCars();
		raceCount.decrementCount();
	}
}
