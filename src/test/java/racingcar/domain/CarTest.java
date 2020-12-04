package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategies.CarMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    @Test
    public void movingNumber가_4이상이면_전진() {
        //given
        Car car = new Car("heon", new OnlyReturnFourStrategy());

        //when
        car.go();

        //then
        assertThat(car.getPosition()).isEqualTo(ONE);
    }

    @Test
    public void movingNumber가_4미만이면_정지() {
        //given
        Car car = new Car("heon", new OnlyReturnThreeStrategy());

        //when
        car.go();

        //then
        assertThat(car.getPosition()).isEqualTo(ZERO);
    }

    private static class OnlyReturnFourStrategy implements CarMovingStrategy {
        @Override
        public int generate() {
            return FOUR;
        }
    }

    private static class OnlyReturnThreeStrategy implements CarMovingStrategy {
        @Override
        public int generate() {
            return THREE;
        }
    }
}