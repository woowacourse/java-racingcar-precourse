package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GameStatus {
	private final Map<String, Integer> gameStatus;

	public GameStatus(Map<String, Integer> gameStatus) {
		this.gameStatus = gameStatus;
	}

	public Map<String, Integer> getRoundStatus() {
		return gameStatus;
	}

	public List<String> getWinnerNames() {
		List<String> winnerNameList = new ArrayList<>();
		for (String name : gameStatus.keySet()) {
			if (gameStatus.get(name) == getMaxPosition()) {
				winnerNameList.add(name);
			}
		}
		return winnerNameList;
	}

	private int getMaxPosition() {
		return Collections.max(gameStatus.values());
	}

}
