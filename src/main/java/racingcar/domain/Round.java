package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Round {
	private final List<Result> results;

	public Round(List<Result> results) {
		this.results = results;
	}

	public List<Result> getRoundResult() {
		return Collections.unmodifiableList(results);
	}

	public List<Result> getWinners() {
		long maxMovement = getMaxMovement();
		return results.stream()
			.filter(element -> element.getCarPosition() == maxMovement)
			.collect(Collectors.toList());
	}

	public long getMaxMovement() {
		return results.stream()
			.mapToInt(Result::getCarPosition)
			.max()
			.orElse(0);
	}
}
