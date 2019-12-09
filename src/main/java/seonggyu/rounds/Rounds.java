package seonggyu.rounds;

public class Rounds {
	private final int rounds;

	public Rounds(int inputRounds) {
		RoundsConstraints.checkValidRounds(inputRounds);
		this.rounds = inputRounds;
	}

	public int getRounds() {
		return this.rounds;
	}
}
