package dto;

import model.car.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttemptResultTest {
    Car car = new Car("Chris");
    private final AttemptResult attemptResult = new AttemptResult(car);

    @Test
    @DisplayName("이름 값을 반환한다.")
    void getName() {
        String actual = attemptResult.getName();
        String expected = "Chris";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("위치 값을 반환한다.")
    void getPosition() {
        int actual = attemptResult.getPosition();
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }
}