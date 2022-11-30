package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 기준보다_작은_수_이동하지_않음_확인() {
        NumberGenerator numberGenerator = new TestNumberGenerator(3);
        Car car = new Car("June");
        car.moveOrStop(numberGenerator);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 기준보다_큰수_이동_확인() {
        NumberGenerator numberGenerator = new TestNumberGenerator(7);
        Car car = new Car("June");
        car.moveOrStop(numberGenerator);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    class TestNumberGenerator implements NumberGenerator {

        private final int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generate() {
            return number;
        }
    }
}