package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class RoundStatusTest {

	@Test
	void getSingerWinnerNameTest() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("바흐", 5);
		hashMap.put("쇼팽", 1);
		hashMap.put("리스트", 2);

		RoundStatus roundStatus = new RoundStatus(hashMap);

		String[] winnerNames = roundStatus.getWinnerNames();
		String[] actual = new String[] {"바흐"};

		Set<String> winnerNamesSet = new HashSet<>(Arrays.asList(winnerNames));
		Set<String> actualSet = new HashSet<>(Arrays.asList(actual));
		assertEquals(winnerNamesSet, actualSet);
	}

	@Test
	void getMultipleWinnerNamesTest() {
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("바흐", 5);
		hashMap.put("쇼팽", 5);
		hashMap.put("리스트", 2);

		RoundStatus roundStatus = new RoundStatus(hashMap);

		String[] winnerNames = roundStatus.getWinnerNames();
		String[] actual = new String[] {"바흐", "쇼팽"};

		Set<String> winnerNamesSet = new HashSet<>(Arrays.asList(winnerNames));
		Set<String> actualSet = new HashSet<>(Arrays.asList(actual));
		assertEquals(winnerNamesSet, actualSet);
	}

}