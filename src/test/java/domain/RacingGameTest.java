package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
	@Test
	@DisplayName("RacingGame 생성시 Rail의 id가 identity를 갖도록 생성")
	void generateRacingGame() {
		List<String> names = Arrays.asList("a", "b", "c");
		RacingGame racingGame = new RacingGame(names);

		List<Integer> collect = racingGame.getRails().stream()
			.map(Rail::getRailNo)
			.collect(Collectors.toList());

		assertThat(collect).containsExactly(1, 2, 3);
	}

}