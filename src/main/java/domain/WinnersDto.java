package domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersDto {
	private List<String> winnerNames;

	private WinnersDto(List<String> winnerNames) {
		this.winnerNames = winnerNames;
	}

	public static WinnersDto from(Winners winners) {
		List<String> winnerNames = winners.getWinners().stream()
			.map(car -> car.getName().toString())
			.collect(Collectors.toList());

		return new WinnersDto(winnerNames);
	}

	public List<String> getWinnerNames() {
		return this.winnerNames;
	}
}
