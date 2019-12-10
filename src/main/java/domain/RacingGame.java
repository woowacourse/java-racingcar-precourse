package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<Rail> rails;

	private int InjectionId = 1;

	public RacingGame(List<String> carNames) {
		rails = carNames.stream()
			.map(this::makeOneRail)
			.collect(Collectors.toList());
	}

	private Rail makeOneRail(String name) {
		return new Rail(InjectionId++, name);
	}
}
