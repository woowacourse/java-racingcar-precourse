package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategies.MustGoMovingStrategy;
import racingcar.domain.strategies.MustStopMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    public void movingNumber가_4이상이면_전진() {
        //given
        Car car = new Car("heon", new MustGoMovingStrategy());

        //when
        car.go();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void movingNumber가_4미만이면_정지() {
        //given
        Car car = new Car("heon", new MustStopMovingStrategy());

        //when
        car.go();

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}