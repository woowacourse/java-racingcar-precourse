package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class GameStatusTest {

	@Test
	void getSingerWinnerNameTest() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("바흐", 5);
		hashMap.put("쇼팽", 1);
		hashMap.put("리스트", 2);

		GameStatus gameStatus = new GameStatus(hashMap);

		List<String> winnerNames = gameStatus.getWinnerNames();
		List<String> expected = Arrays.asList("바흐");
		assertTrue(
			winnerNames.size() == expected.size() &&
				winnerNames.containsAll(expected) &&
				expected.containsAll(winnerNames)
		);
	}

	@Test
	void getMultipleWinnerNamesTest() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("바흐", 5);
		hashMap.put("쇼팽", 5);
		hashMap.put("리스트", 2);

		GameStatus gameStatus = new GameStatus(hashMap);

		List<String> winnerNames = gameStatus.getWinnerNames();
		List<String> expected = Arrays.asList("바흐", "쇼팽");
		assertTrue(
			winnerNames.size() == expected.size() &&
				winnerNames.containsAll(expected) &&
				expected.containsAll(winnerNames)
		);
	}

}