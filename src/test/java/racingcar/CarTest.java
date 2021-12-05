package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import racingcar.car.Car;

class CarTest {
    private final Car car = Car.create("car");

    @Test
    void 주행시_인자로_4이상의_수가_전달되면_position_1_증가() {
        int initPosition = 0;
        int biggerThanFour = 5;

        assertThat(car.run(biggerThanFour)).isEqualTo(initPosition + 1);
    }

    @Test
    void 주행시_인자로_4미만의_수가_전달되면_position_변경_없음() {
        int initPosition = 0;
        int smallerThanFour = 1;

        assertThat(car.run(smallerThanFour)).isEqualTo(initPosition);
    }
}
