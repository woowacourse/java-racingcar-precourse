package racingcar.view.output;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.config.ViewConfig;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarSet;
import racingcar.domain.movement.InputMovementStrategy;

class OutputResultViewTest {
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	public void testOutputResult() {
	    // given
		CarSet carSet = new CarSet(Arrays.asList(new Car("A"), new Car("B")));
		carSet.move(new InputMovementStrategy(3));
		OutputResultView view = ViewConfig.getOutputResultView();
	    // when
	    view.showResult(carSet);
	    // then
		assertEquals("최종 우승자 : A, B\n", outputStream.toString());
	}

}