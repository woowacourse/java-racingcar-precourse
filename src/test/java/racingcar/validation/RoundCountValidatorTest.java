package racingcar.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RoundCountValidatorTest {
    private final String ROUND_NUMBER_NORMAL = "20";

    @Test
    void 라운드_입력_정상() {
        assertThat(RoundCountValidator.checkRoundCountAndReturn(ROUND_NUMBER_NORMAL))
                .isEqualTo(Integer.parseInt(ROUND_NUMBER_NORMAL));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", ""})
    void 라운드_입력_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RoundCountValidator.checkRoundCountAndReturn(input))
                .withMessageStartingWith("[ERROR]");
    }
}
