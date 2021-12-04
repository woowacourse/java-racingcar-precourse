package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarToStringTest {

    @Test
    void 자동차_출력기능_작동확인() {
        String answer = "hello : ___";

        Car car = new Car("hello");
        car.forward();
        car.forward();
        car.forward();

        assertThat(car.toString()).isEqualTo(answer);
    }
}
