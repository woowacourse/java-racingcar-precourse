package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Round {
	private static final String RESULT = "-";
	private Map<String, Integer> roundResult;

	public Round(Cars cars) {
		makeRoundResult(cars);
	}

	public void makeRoundResult(Cars cars) {
		this.roundResult = cars.makeRoundResult();
	}

	public String getRoundResult() {
		return roundResult.entrySet()
			.stream()
			.map(element -> element.getKey() + " : " + String.join("",
				Collections.nCopies(element.getValue(), RESULT)))
			.collect(Collectors.joining("\n"));
	}

	public List<String> getWinners() {
		long maxMovement = roundResult.values()
			.stream()
			.max(Comparator.naturalOrder())
			.orElse(-1);
		return roundResult.entrySet()
			.stream()
			.filter(element -> element.getValue() == maxMovement)
			.map(Map.Entry::getKey)
			.collect(Collectors.toList());
	}
}
