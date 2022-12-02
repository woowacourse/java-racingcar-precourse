package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    static final String name = "pobi";

    @Test
    void move_4_이상_값이_들어가면_움직인다() {
        Car car = new Car(name, () -> 5);
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void move_4_미만_값이_들어가면_움직이지_않는다() {
        Car car = new Car(name, () -> 3);
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
