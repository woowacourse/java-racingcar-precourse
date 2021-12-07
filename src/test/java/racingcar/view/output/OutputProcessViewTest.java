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

class OutputProcessViewTest {

	private ByteArrayOutputStream outputStream;

	@BeforeEach
	public void changeOutput() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	public void testOutputProcess() {
	    // given
		CarSet carSet = new CarSet(Arrays.asList(new Car("A"), new Car("B")));
		carSet.move(new InputMovementStrategy(3));
		OutputProcessView view = ViewConfig.getOutputProcessView();
		// when
	    view.showProcess(carSet);
	    // then
		assertEquals("A : ---\nB : ---\n\n", outputStream.toString());
	}
}