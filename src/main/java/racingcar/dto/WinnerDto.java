package racingcar.dto;

import java.util.List;

public class WinnerDto {

	private List<String> winnerNames;

	public WinnerDto(List<String> names) {
		winnerNames.addAll(names);
	}

	public List<String> getNames() {
		return winnerNames;
	}
}
