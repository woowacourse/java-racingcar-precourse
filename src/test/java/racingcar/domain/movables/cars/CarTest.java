package racingcar.domain.movables.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.movables.engine.Movable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car("jun");
        car.move(() -> true);
        car.move(() -> true);
    }
    
    @Test
    @DisplayName("차 이동")
    void move() {
        assertThat(car.position()).isEqualTo(2);
    }
    
    @DisplayName("Position 같은지 확인")
    @ParameterizedTest(name = "{displayName} : maxPosition => {0}, result => {1}")
    @CsvSource(value = {"1, false", "2, true", "3, false"})
    void isPositionSame(final int maxPosition, final boolean result) {
        assertThat(car.isPositionSame(maxPosition)).isEqualTo(result);
    }
}