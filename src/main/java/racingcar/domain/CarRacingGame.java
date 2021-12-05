package racingcar.domain;

public class CarRacingGame {
	private final int movesNumber;
	private int nowRoundNum = 0;

	public CarRacingGame(int movesNumber) {
		this.movesNumber = movesNumber;
	}

	public boolean checkOneMoreRoundPossible() {
		return (nowRoundNum++ < movesNumber);
	}
}
