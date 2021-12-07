package racingcar.util;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class ConversionUtilsTest {
	@Test
	void 이름리스트_자동차리스트로_변환() {
		// given, when
		List<String> carNameList = Arrays.asList("자1동차", "자2동차", "자3동차");

		// then
		Assertions.assertThat(ConversionUtils.getCarListFromNameList(carNameList).stream().map(Car::getName))
			.containsAll(carNameList);

	}
}
