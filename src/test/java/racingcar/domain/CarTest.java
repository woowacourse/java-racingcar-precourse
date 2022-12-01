package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void 주어진_범위_이상의_수가_입력되면_자동차가_전진할_수_있다(int number) {
        Car car = new Car("car");

        assertThat(car.canMove(number)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 주어진_범위보다_작은_수가_입력되면_자동차가_전진할_수_없다(int number) {
        Car car = new Car("car");

        assertThat(car.canMove(number)).isEqualTo(false);
    }

}