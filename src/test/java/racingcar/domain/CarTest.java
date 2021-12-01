package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("자동차 전진 테스트")
    @Test
    void move() {
        Car myCar = new Car("myCar");
        assertThat(myCar.getPosition()).isEqualTo(0);
        myCar.move();
        assertThat(myCar.getPosition()).isEqualTo(1);
        myCar.move();
        assertThat(myCar.getPosition()).isEqualTo(2);
    }
}
