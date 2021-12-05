package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringConstants.MIN_NUMBER_TO_CAR_TO_GO;

import org.junit.jupiter.api.Test;

import racingcar.car.Car;
import racingcar.view.RacingResultView;

class RacingResultViewTest {

    @Test
    void 출력_형식에_맞게_출력() {
        String expectedResult = "pobi : -";
        String carName = "pobi";
        Car car = Car.create(carName);
        car.run(MIN_NUMBER_TO_CAR_TO_GO);

        RacingResultView racingResultView = new RacingResultView(car);

        assertThat(racingResultView.writeResult().toString()).isEqualTo(expectedResult);
    }
}
