package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarCollectionTest {
	@Test
	@DisplayName("CarCollection 생성시 Rail의 id가 identity를 갖도록 생성")
	void generateRacingGame() {
		List<String> names = Arrays.asList("a", "b", "c");
		CarCollection carCollection = new CarCollection(names);

		List<Integer> collect = carCollection.getCars().stream()
			.map(Car::getRailId)
			.collect(Collectors.toList());

		assertThat(collect).containsExactly(1, 2, 3);
	}

}