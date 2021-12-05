package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class CarTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;
	private static final String CAR_NAME = "ozr";
	private static final String CAR1 = "car1";
	private static final String CAR2 = "car2";
	private static final String POSITION_BAR = "-";

	@DisplayName("getName 기능 테스트")
	@Test
	public void getNameTest() {
		Car car = new Car(CAR_NAME);
		assertEquals(CAR_NAME, car.getName());
	}

	@DisplayName("moveForward 전진 기능 테스트")
	@Test
	public void moveForwardTest() {
		assertRandomNumberInRangeTest(
			() -> {
				run();
				assertThat(output()).contains(POSITION_BAR);
			},
			MOVING_FORWARD
		);
	}

	@DisplayName("moveForward 정지 기능 테스트")
	@Test
	public void stopTest() {
		assertRandomNumberInRangeTest(
			() -> {
				run();
				assertThat(output()).doesNotContain(POSITION_BAR);
			},
			STOP
		);
	}

	@DisplayName("compareTo 기능 테스트")
	@Test
	public void compareToTest() {
		Car car1 = new Car(CAR1);
		Car car2 = new Car(CAR2);
		assertRandomNumberInRangeTest(
			() -> {
				assertEquals(car1.compareTo(car2), 0);
				car1.moveForward();
				assertEquals(car1.compareTo(car2), 1);
			},
			MOVING_FORWARD
		);
	}

	@DisplayName("isSamePosition 기능 테스트")
	@Test
	public void isSamePositionTest() {
		Car car1 = new Car(CAR1);
		Car car2 = new Car(CAR2);
		assertRandomNumberInRangeTest(
			() -> {
				assertTrue(car1.isSamePosition(car2));
				car1.moveForward();
				assertFalse(car1.isSamePosition(car2));
				car2.moveForward();
				assertTrue(car1.isSamePosition(car2));
			},
			MOVING_FORWARD, MOVING_FORWARD
		);
	}

	@DisplayName("printState 기능 테스트")
	@Test
	public void printStateTest() {
		Car car = new Car(CAR_NAME);
		assertRandomNumberInRangeTest(
			() -> {
				car.moveForward();
				car.moveForward();
				car.printState();
				assertThat(output()).contains(CAR_NAME + " : --");
			},
			MOVING_FORWARD, MOVING_FORWARD
		);
	}

	@Override
	protected void runMain() {
		Car car = new Car(CAR_NAME);
		car.moveForward();
		car.printState();
	}
}
