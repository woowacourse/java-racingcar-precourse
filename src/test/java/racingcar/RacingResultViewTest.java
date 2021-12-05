package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.StringConstants.MIN_NUMBER_TO_CAR_TO_GO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingResultViewTest {

    @Test
    void 출력_형식에_맞게_출력() {
        String expectedResult = "pobi : -";
        String carName = "pobi";
        Car car = Car.create(carName);
        car.run(MIN_NUMBER_TO_CAR_TO_GO);

        RacingResultView racingResultView = new RacingResultView(car);

        assertThat( racingResultView.writeResult().toString()).isEqualTo(expectedResult);
    }
}
