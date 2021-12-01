package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class CarTest {
	MockedStatic<Randoms> randomsMockedStatic;

	@BeforeEach
	public void setUp() throws Exception {
		randomsMockedStatic = mockStatic(Randoms.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		randomsMockedStatic.close();
	}

	@Test
	@DisplayName("앞으로 전진")
	void move_forward() {
		when(Randoms.pickNumberInRange(0, 9))
			.thenReturn(4)
			.thenReturn(7);
		Car car = new Car("pobi");

		car.move();
		assertThat(car.getPosition()).isEqualTo(1);

		car.move();
		assertThat(car.getPosition()).isEqualTo(2);
	}

	@Test
	@DisplayName("정지")
	void stop() {
	    when(Randoms.pickNumberInRange(0, 9))
		    .thenReturn(3)
		    .thenReturn(2);
		Car car = new Car("pobi");

		car.move();
		assertThat(car.getPosition()).isEqualTo(0);

		car.move();
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
