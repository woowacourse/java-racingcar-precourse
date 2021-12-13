package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Randoms;

class CarTest {

    @Test
    @DisplayName("Random값이 4 이상이 나오면 자동차는 움직여야 한다.")
    void 자동차_움직이는경우() {
        Car car = new Car("taehoon") {
            @Override
            protected boolean canMoveCar() {
                return 4 >= VALUE_MOVING_CAR;
            }
        };
        car.move();
        Assertions.assertThat(car.showMovingDistance() == 1).isTrue();
    }

    @Test
    @DisplayName("Random값이 4보다 작으면 자동차는 움직이지 않는다.")
    void 자동차_움직이지_않는경우() {
        Car car = new Car("taehoon") {
            @Override
            protected boolean canMoveCar() {
                return 3 >= VALUE_MOVING_CAR;
            }
        };
        car.move();
        Assertions.assertThat(car.showMovingDistance() == 1).isFalse();
    }
}