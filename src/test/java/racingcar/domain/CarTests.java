package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    public void 자동차_전진_성공(int forwardCount) {
        Car car = new Car("test");

        for (int i = 0; i < forwardCount; i++) {
            car.forwardOneStep();
        }

        assertThat(car.getPosition())
                .isEqualTo(forwardCount);
    }
}
