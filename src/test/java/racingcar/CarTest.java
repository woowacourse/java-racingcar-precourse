package racingcar;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 이름은 5자 이하여야 한다.")
    void 자동차_이름_유효성_성공_테스트() {
        Car fives = new Car("fives");
        assertThat(fives).isNotNull();
    }

    @Test
    @DisplayName("자동차의 이름은 5자 초과이면 예외처리한다.")
    void 자동차_이름_유효성_실패_테스트() {
        //given
        assertThatThrownBy(() -> new Car("sixCar"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
