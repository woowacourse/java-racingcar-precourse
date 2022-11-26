package racingcar.domain.movables.cars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    
    @Test
    @DisplayName("차 이동")
    void move() {
        Car car = new Car("jun");
        car.move();
        car.move();
        
        assertThat(car.position()).isEqualTo(2);
    }
}