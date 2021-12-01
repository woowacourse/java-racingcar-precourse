package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
	@Test
	@DisplayName("차 이름이 5글자가 넘지 않는지 테스트")
	void validCarNameTest() {
		String testCarName = "sojukang";
		assertThat(ValidationUtils.validCarName(testCarName)).isFalse();
	}

	@Test
	@DisplayName("이름 \",\"로 구분하여 리스트로 저장 테스트")
	void carNames() {
		String cars = "abc,def,ghi,jkl";
		List<String> arrCars = new ArrayList<>();
		arrCars.add("abc");
		arrCars.add("def");
		arrCars.add("ghi");
		arrCars.add("jkl");

		assertThat(Car.generateCars(cars).containsAll(arrCars)).isTrue();
	}
}
