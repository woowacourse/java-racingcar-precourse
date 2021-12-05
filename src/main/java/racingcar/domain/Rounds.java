package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rounds {
	private final List<Round> rounds;

	public Rounds() {
		rounds = new ArrayList<>();
	}

	public void add(Round round) {
		rounds.add(round);
	}

	public List<String> getRoundResult() {
		return rounds.stream()
			.map(Round::getRoundResult)
			.collect(Collectors.toList());
	}

	public List<String> getWinner() {
		return rounds.stream()
			.reduce((first, second) -> second)
			.get()
			.getWinners();
	}
}
