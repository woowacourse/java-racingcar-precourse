package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
	private final List<Round> rounds;

	public Rounds() {
		rounds = new ArrayList<>();
	}

	public void add(Round round) {
		rounds.add(round);
	}

}
