package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("중복된 이름을 가진 자동차가 있을 경우 Exception이 발생해야 한다.")
    void createExceptionByDuplicateNameTest() {
        // given
        List<String> input = Arrays.asList("pobi", "pobi");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Cars.createRandomCars(input))
            .withMessage("[ERROR] 중복된 Car 이름이 존재할 수 없습니다.");
    }
}