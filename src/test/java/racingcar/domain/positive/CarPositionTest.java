package racingcar.domain.positive;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.positive.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

class CarPositionTest {
    
    @Test
    @DisplayName("포지션 증가")
    void increase() {
        CarPosition carPosition = new CarPosition(1);
        carPosition = carPosition.increase();
        
        assertThat(carPosition.number()).isEqualTo(2);
    }
}