package racingcar.controller.dto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialDtoTest {

    private final String ERROR = "[ERROR]";

    @DisplayName("자연수가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "f", "-1"})
    void buildWithNotNaturalNumber(String input) {
        assertThatThrownBy(() -> TrialDto.builder().trial(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
