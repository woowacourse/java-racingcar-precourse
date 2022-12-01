package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("이름의 길이가 5자를 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"abcdef", "1234567"})
    void nameValidateTest(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 위치를 이동시킨다.")
    @Test
    void addPosition() {
        Car car = new Car("hello");

        car.addPosition();

        assertThat(car.getPosition()).isEqualTo(1);
    }

}