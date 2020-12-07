package utils.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    @Test
    void 자동차이름_길이_테스트() {
        // given, when
        String carName = "binghe";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCarName(carName);
        });
    }

    @Test
    void 자동차이름_빈칸_테스트() {
        // given, when
        String carName = " ";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameValidator.validateCarName(carName);
        });
    }
}