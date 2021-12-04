package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class WinnerDto {

	private List<String> winnerNames;

	public WinnerDto(List<String> names) {
		this.winnerNames = new ArrayList<>(names);
	}

	public List<String> getNames() {
		return this.winnerNames;
	}
}
