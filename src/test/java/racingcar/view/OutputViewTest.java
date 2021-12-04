package racingcar.view;

import static org.assertj.core.api.Assertions.*;
import static racingcar.util.SymbolicConstantUtil.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RacingRecord;
import racingcar.domain.RacingResult;

class OutputViewTest {
	private static final int MOVING_FORWARD = 4;

	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private List<Car> cars = new ArrayList<>();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(output));
	}

	@BeforeEach
	public void setUpCars() {
		cars.add(new Car("hoon"));
		cars.add(new Car("wish"));
	}

	@Test
	void 승리자가_2이상인_경우_콤마_생성() {
		// given
		cars.forEach(car -> car.drive(MOVING_FORWARD));
		RacingResult racingResult = new RacingResult(cars);

		// when
		OutputView.printRacingWinners(racingResult);

		// then
		assertThat(output.toString()).contains(COMMA);
	}

	@Test
	void 게임결과_출력시_전진값에_대한_대쉬기호_생성() {
		// given
		cars.forEach(car -> car.drive(MOVING_FORWARD));
		RacingRecord racingRecord = new RacingRecord(cars);

		// when
		OutputView.printRacingRecord(racingRecord);

		// then
		assertThat(output.toString()).contains("hoon : -", "wish : -");
	}
}
