package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringUtils.MIN_NUMBER_TO_CAR_TO_GO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.car.Car;
import racingcar.gameresult.RacingResult;

class RacingResultViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void 출력_형식에_맞게_출력() {
        String expectedResult = "pobi : -";
        String carName = "pobi";
        Car car = Car.create(carName);
        car.run(MIN_NUMBER_TO_CAR_TO_GO);

        new RacingResultView(new RacingResult(car)).print();

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expectedResult);
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}
