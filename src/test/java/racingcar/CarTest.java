package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarMovingFlag;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void STOP_플래그_추가() {
        // given
        final String carName = "kkh";
        CarMovingFlag stopFlag = CarMovingFlag.STOP;
        Car car = new Car(carName);

        // when
        car.updatePositionByFlag(stopFlag);

        // then
        assertThat(car.getPosition() == 0).isTrue();
    }

    @Test
    void FORWARD_플래그_추가() {
        // given
        final String carName = "kkh";
        CarMovingFlag stopFlag = CarMovingFlag.FORWARD;
        Car car = new Car(carName);

        // when
        car.updatePositionByFlag(stopFlag);

        // then
        assertThat(car.getPosition() == 1).isTrue();
    }
}