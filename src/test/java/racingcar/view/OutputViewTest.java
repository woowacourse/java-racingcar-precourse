package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static racingcar.view.OutputView.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.domain.Car;

public class OutputViewTest extends NsTest {
	private static final String CAR_NAME = "car";
	private static final int CAR_POSITION = 1;
	private static final String POSITION_BAR = getPositionBar();

	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("printReadCarNamesMessage 테스트")
	@Test
	public void printReadCarNamesMessageTest() {
		printReadCarNamesMessage();
		assertThat(output()).contains(getReadCarNamesMassage());
	}

	@DisplayName("printReadRacingRoundMessage 테스트")
	@Test
	public void printReadRacingRoundMessageTest() {
		printReadRacingRoundMessage();
		assertThat(output()).contains(getReadRacingRoundMassage());
	}

	@DisplayName("printStartRoundMessage 테스트")
	@Test
	public void printStartRoundMessageTest() {
		printStartRoundMessage();
		assertThat(output()).contains(getStartRoundMassage());
	}

	@DisplayName("printCarState 테스트")
	@Test
	public void printCarStateTest() {
		printCarState(CAR_NAME, CAR_POSITION);
		assertThat(output()).contains(CAR_NAME, POSITION_BAR);
	}

	@DisplayName("printWinners 테스트")
	@Test
	public void printWinnersTest() {
		List<Car> winners = new LinkedList<>();
		winners.add(new Car(CAR_NAME));
		printWinners(winners);
		assertThat(output()).contains(CAR_NAME);
	}

	@DisplayName("printErrorMessage 테스트")
	@Test
	public void printErrorMessageTest() {
		printErrorMessage(new IllegalArgumentException(ERROR_MESSAGE));
		assertThat(output()).contains(ERROR_MESSAGE);
	}

	@Override
	protected void runMain() {
	}
}
