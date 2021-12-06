package model;

public class RacingCarGame {
	private static final int GAME_FINISH_COUNT = 0;
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
		if (raceCount.getCount() != GAME_FINISH_COUNT) {
			return true;
		}
		return false;
	}

	public String[] giveRacingCarNames() {
		return racingCars.bringCarNames();
	}

	public int[] giveRacingCarPositions() {
		return racingCars.bringCarPositions();
	}

	public String[] giveWinner() {
		winner = new Winner(giveRacingCarNames(), giveRacingCarPositions());
		return winner.getWinners().stream().toArray(String[]::new);
	}
}
