package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차의 이름 길이가 5를 초과하면 예외를 던진다.")
    void name_length_over_max_length_throws_Exception() {
        String name = "overMax";
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 숫자가 4이상인 경우 position을 증가시킨다.")
    void increase_position_if_number_ge_than_4() {
        // given
        Car car = new Car("test");
        int initPosition = car.getPosition();

        // when
        car.attemptMove(4);
        int afterMovePosition = car.getPosition();

        // then
        int diff = afterMovePosition - initPosition;
        assertThat(diff).isEqualTo(1);
    }

}