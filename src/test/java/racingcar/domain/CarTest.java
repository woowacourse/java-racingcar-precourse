package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void fromTest() {
        Car car = Car.from("pobi");
        System.out.println(car);
        assertThat(car.toString()).isEqualTo("class racingcar.domain.Car@name: pobi, position: 0");
    }
}
