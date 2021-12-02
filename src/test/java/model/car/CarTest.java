package model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private final Car car = new Car("Chris");

    @Test
    @DisplayName("이름을 반환한다.")
    void getName() {
        String actual = car.getName();
        String expected = "Chris";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차를 전진시키고 전진에 따른 위치 값을 반환한다.")
    void move_getPosition() {
        car.move(true);
        car.move(false);
        int actual = car.getPosition();
        int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }
}
