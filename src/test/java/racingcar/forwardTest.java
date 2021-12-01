package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class forwardTest {
	@Test
	@DisplayName("전진 테스트")
	void forward_test() {
		Car testCar = new Car("testCar");
		int testPosition = testCar.getPosition();
		testCar.forward();
		assertThat(testPosition + 1 == testCar.getPosition()).isTrue();
	}
}
