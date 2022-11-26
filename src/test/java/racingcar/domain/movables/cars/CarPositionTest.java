package racingcar.domain.movables.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarPositionTest {
    
    @Test
    @DisplayName("포지션 증가")
    void increase() {
        CarPosition carPosition = new CarPosition(1);
        carPosition = carPosition.increase();
        
        assertThat(carPosition.position()).isEqualTo(2);
    }
}