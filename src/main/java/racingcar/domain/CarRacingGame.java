package racingcar.domain;

public class CarRacingGame {
	private final int movesNumber;
	private int nowRoundNum = 0;
	private Rounds rounds;

	public CarRacingGame(int movesNumber) {
		this.movesNumber = movesNumber;
		rounds = new Rounds();
	}

	public boolean checkOneMoreRoundPossible() {
		return (nowRoundNum++ < movesNumber);
	}

	public void roundsAdd(Round round) {
		rounds.add(round);
	}

}
