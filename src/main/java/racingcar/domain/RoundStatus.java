package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RoundStatus {
	private final Map<String, Integer> roundStatus;

	public RoundStatus(Map<String, Integer> roundStatus) {
		this.roundStatus = roundStatus;
	}

	public Map<String, Integer> getRoundStatus() {
		return roundStatus;
	}

	public String[] getWinnerNames() {
		List<String> winnerNameList = new ArrayList<>();
		for (String name : roundStatus.keySet()) {
			if (roundStatus.get(name) == getMaxPosition()) {
				winnerNameList.add(name);
			}
		}
		return winnerNameList.toArray(new String[0]);
	}

	private int getMaxPosition() {
		return Collections.max(roundStatus.values());
	}
}
