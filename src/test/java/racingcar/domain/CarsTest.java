package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class CarsTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private final String[] names = new String[] {"ozr", "rag", "wort"};
	private static final String POSITION_BAR = "-";

	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("racing 기능 테스트")
	@Test
	public void racingTest() {
		assertRandomNumberInRangeTest(
			() -> {
				Cars cars = new Cars(names);
				cars.racing();
				assertThat(output()).contains(
					names[0] + " : " + POSITION_BAR,
					names[2] + " : " + POSITION_BAR
				);
			},
			MOVING_FORWARD, STOP, MOVING_FORWARD
		);
	}

	@DisplayName("findWinners 기능 테스트")
	@Test
	public void findWinnersTest() {
		assertRandomNumberInRangeTest(
			() -> {
				Cars cars = new Cars(names);
				cars.racing();
				List<Car> winners = cars.findWinners();
				assertEquals(winners.size(), 2);
				assertEquals(winners.get(0).getName(), names[0]);
				assertEquals(winners.get(1).getName(), names[2]);
			},
			MOVING_FORWARD, STOP, MOVING_FORWARD
		);
	}

	@DisplayName("findWinners 예외 테스트")
	@Test
	public void findWinnersExceptionTest() {
		assertSimpleTest(
			() -> {
				Cars cars = new Cars(new String[0]);
				IllegalArgumentException exception =
					assertThrows(
						IllegalArgumentException.class,
						cars::findWinners
					);
				assertThat(exception.getMessage())
					.contains(ERROR_MESSAGE);
			}
		);
	}

	@Override
	protected void runMain() {
	}
}
