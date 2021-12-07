package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class GameStatusTest {

	@Test
	void getSingerWinnerNameTest() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("바흐", 5);
		hashMap.put("쇼팽", 1);
		hashMap.put("리스트", 2);

		GameStatus gameStatus = new GameStatus(hashMap);

		String[] winnerNames = gameStatus.getWinnerNames();
		String[] expected = new String[] {"바흐"};

		Set<String> winnerNamesSet = new HashSet<>(Arrays.asList(winnerNames));
		Set<String> expectedSet = new HashSet<>(Arrays.asList(expected));
		assertEquals(winnerNamesSet, expectedSet);
	}

	@Test
	void getMultipleWinnerNamesTest() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("바흐", 5);
		hashMap.put("쇼팽", 5);
		hashMap.put("리스트", 2);

		GameStatus gameStatus = new GameStatus(hashMap);

		String[] winnerNames = gameStatus.getWinnerNames();
		String[] expected = new String[] {"바흐", "쇼팽"};
		
		Set<String> winnerNamesSet = new HashSet<>(Arrays.asList(winnerNames));
		Set<String> expectedSet = new HashSet<>(Arrays.asList(expected));
		assertEquals(winnerNamesSet, expectedSet);
	}

}