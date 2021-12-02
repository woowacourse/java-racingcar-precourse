package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Cars cars;

    @BeforeEach
    void SetUp() {
        cars = new Cars();
    }

    @Test
    void 자동차_이름에_대한_예외_출력테스트() {
        assertThatThrownBy(() -> {
            cars.addCar("pobi,minjaea");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}