package model;

public class RacingCarGame {
	private RacingCars racingCars;
	private RaceCount raceCount;
	private Winner winner;

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

	public boolean isRacingNotFinish() {
		if (raceCount.getCount() != 0) {
			return true;
		}
		return false;
	}

	public String[] giveRacingCarNames() {
		return racingCars.findCarNames();
	}

	public int[] giveRacingCarPositions() {
		return racingCars.findCarPositions();
	}

	public String[] giveWinner() {
		winner = new Winner(giveRacingCarNames(), giveRacingCarPositions());
		return winner.getWinners().stream().toArray(String[]::new);
	}
}
