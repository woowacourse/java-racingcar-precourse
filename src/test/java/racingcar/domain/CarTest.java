package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    Car myCar;

    @BeforeEach
    void setUp() {
        myCar = new Car("myCar");
    }

    @DisplayName("자동차 전진 및 정지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void moveTest(int input, int expected) {
        myCar.move(input);
        assertThat(myCar.getPosition()).isEqualTo(expected);
    }

    @DisplayName("자동차 연속 전진 테스트")
    @Test
    void continuouslyMoveTest() {
        myCar.move(4);
        assertThat(myCar.getPosition()).isEqualTo(1);
        myCar.move(4);
        assertThat(myCar.getPosition()).isEqualTo(2);
    }
}
